package com.example.kennelmanagercompose.domain.services.calculators

import com.example.kennelmanagercompose.domain.enums.SessionStatus
import com.example.kennelmanagercompose.domain.models.activity.RunScore
import com.example.kennelmanagercompose.domain.models.activity.Session
import com.example.kennelmanagercompose.domain.models.config.RunRules
import com.example.kennelmanagercompose.domain.models.config.WorkRules
import com.example.kennelmanagercompose.domain.models.dog.Dog
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Period
import java.time.ZoneId
import java.time.format.DateTimeFormatter

object ReadyToRunCalculator {

    // STATE: Maps a Date -> (DogId -> List of Statuses)
    private var sessionData: Map<LocalDate, Map<String, List<SessionStatus>>> = emptyMap()

    fun updateSessions(allSessions: List<Session>) {
        val newMap = mutableMapOf<LocalDate, MutableMap<String, MutableList<SessionStatus>>>()
        for (session in allSessions) {
            val date = try {
                LocalDateTime.parse(session.startTime, DateTimeFormatter.ISO_DATE_TIME).toLocalDate()
            } catch (e: Exception) { continue }

            if (session.status == SessionStatus.CANCELLED) continue

            val dailyMap = newMap.getOrPut(date) { mutableMapOf() }
            for (dogId in session.dogTeam.members) {
                dailyMap.getOrPut(dogId) { mutableListOf() }.add(session.status)
            }
        }
        sessionData = newMap
    }

    // --- MAIN PUBLIC FUNCTION ---
    fun calculateScore(
        dog: Dog,
        targetDate: LocalDate,
        runRules: RunRules,
        workRules: WorkRules
    ): RunScore {

        // Step 1: Age Checks (Babies & Younglings)
        val ageResult = checkAgeRules(dog, targetDate, workRules)
        if (ageResult != null) return ageResult

        // Step 2: Safety & Capacity Checks (Max runs/day)
        val safetyResult = checkSafetyRules(dog, targetDate, workRules)
        if (safetyResult != null) return safetyResult

        // Step 3: History & Fatigue (The 10-day math)
        return calculateFatigue(dog, targetDate, runRules)
    }


    // --- HELPER 1: AGE LOGIC ---
    private fun checkAgeRules(dog: Dog, targetDate: LocalDate, workRules: WorkRules): RunScore? {
        // 1. Calculate Age
        val birthDateLocal = dog.birthday.atZone(ZoneId.systemDefault()).toLocalDate()
        val ageInMonths = Period.between(birthDateLocal, targetDate).toTotalMonths()

        // 2. Check Overrides or Defaults
        val minAge = dog.workOverrides.minRunAgeMonths ?: workRules.minRunAgeMonths

        if (ageInMonths < minAge) {
            return RunScore(-100, "Too Young (${ageInMonths}m < ${minAge}m)")
        }
        return null // Null means "Passed this check"
    }


    // --- HELPER 2: SAFETY & CAPACITY ---
    private fun checkSafetyRules(dog: Dog, targetDate: LocalDate, workRules: WorkRules): RunScore? {
        val birthDateLocal = dog.birthday.atZone(ZoneId.systemDefault()).toLocalDate()
        val ageInMonths = Period.between(birthDateLocal, targetDate).toTotalMonths()

        // Determine effective limits
        val younglingAge = dog.workOverrides.younglingAgeMonths ?: workRules.younglingAgeMonths //if null on dog overrides, use workrules
        val maxSessions = dog.workOverrides.maxSessionsPerDay ?: workRules.maxYounglingSessions

        val isYoungling = ageInMonths < younglingAge
        val hasLimitOverride = dog.workOverrides.maxSessionsPerDay != null

        // Only check capacity if they are a youngling OR have a specific override
        if (isYoungling || hasLimitOverride) {
            val sessionsToday = getSessionCount(dog.id, targetDate)

            if (sessionsToday >= maxSessions) {
                return RunScore(-100, "Daily Limit Reached ($sessionsToday/$maxSessions)")
            }
        }
        return null // Passed
    }


    // --- HELPER 3: FATIGUE MATH ---
    private fun calculateFatigue(dog: Dog, targetDate: LocalDate, rules: RunRules): RunScore {
        val history = buildHistoryList(dog.id, targetDate, rules.historyDays)

        // Calculate Streaks
        var currentWorkStreak = 0
        var currentOffStreak = 0
        for (worked in history) {
            if (worked) {
                if (currentOffStreak > 0) break
                currentWorkStreak++
            } else {
                if (currentWorkStreak > 0) break
                currentOffStreak++
            }
        }

        // Check Hard Streak Limits
        val maxStreak = dog.workOverrides.maxWorkDaysInARow ?: rules.maxWorkDaysInARow
        if (currentWorkStreak >= maxStreak) {
            return RunScore(rules.scoreCantRun, "Needs Rest ($currentWorkStreak days worked)")
        }
        if (currentOffStreak >= rules.maxOffDaysInARow) {
            return RunScore(rules.scoreShouldRun, "Rested ($currentOffStreak days off)")
        }

        // Calculate Soft Score
        var score = 0
        val totalWorkDays = history.count { it }
        score -= (totalWorkDays * rules.fatiguePenaltyPerDay)

        if (currentWorkStreak > 0) {
            score -= (currentWorkStreak * rules.recentFatiguePenalty)
            return RunScore(score.coerceIn(-100, 100), "Working Streak: $currentWorkStreak")
        } else {
            // Resting logic
            if (currentOffStreak == 1) score -= 15
            if (currentOffStreak == 2) score += 40
            val statusText = if (currentOffStreak == 1) "Recovery Day 1" else "Recovery Day $currentOffStreak"
            return RunScore(score.coerceIn(-100, 100), statusText)
        }
    }


    // --- UTILS ---
    private fun buildHistoryList(dogId: String, targetDate: LocalDate, days: Int): List<Boolean> {
        val today = LocalDate.now()
        return (1..days).map { daysAgo ->
            val dateToCheck = targetDate.minusDays(daysAgo.toLong())
            val statuses = sessionData[dateToCheck]?.get(dogId) ?: emptyList()

            if (dateToCheck.isBefore(today)) {
                statuses.contains(SessionStatus.DONE) || statuses.contains(SessionStatus.DOING)
            } else {
                statuses.isNotEmpty()
            }
        }
    }

    private fun getSessionCount(dogId: String, date: LocalDate): Int {
        val statuses = sessionData[date]?.get(dogId) ?: emptyList()
        return statuses.count { it != SessionStatus.CANCELLED }
    }
}