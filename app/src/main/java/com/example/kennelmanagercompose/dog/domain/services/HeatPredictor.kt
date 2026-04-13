package com.example.kennelmanagercompose.dog.domain.services

import com.example.kennelmanagercompose.dog.domain.models.logs.HeatLog
import java.time.LocalDate
import java.time.temporal.ChronoUnit

object HeatPredictor {

    // Default average time between heat: 6 months (approx 180 days)
    private val DEFAULT_CYCLE_DAYS: Long = 180

    fun predictNextHeat(history: List<HeatLog>): LocalDate? {
        if (history.isEmpty()) return null // No data to predict from

        // Sort from oldest to newest
        val sortedLogs = history.sortedBy { it.startDate }
        val lastHeat = sortedLogs.last()

        // If currently in heat, no future prediction needed right now
        if (lastHeat.endDate == null) return null

        // If we only have 1 log, use the default 6-month guess
        if (sortedLogs.size == 1) {
            return lastHeat.startDate.plusDays(DEFAULT_CYCLE_DAYS)
        }

        // --- THE SMART PREDICTION ---
        // If we have multiple logs, calculate average cycle length
        var totalDaysBetweenCycles = 0L // ChronoUnit needs this to be a long
        for (i in 1 until sortedLogs.size) {
            val previous = sortedLogs[i - 1].startDate
            val current = sortedLogs[i].startDate
            totalDaysBetweenCycles += ChronoUnit.DAYS.between(
                previous,
                current
            )
        }

        val averageCycleDays = totalDaysBetweenCycles / (sortedLogs.size - 1)

        // Predict the next one by adding her personal average to her last start date
        return lastHeat.startDate.plusDays(averageCycleDays)
    }
}