package com.example.kennelmanagercompose.pooptracking.domain.services

import com.example.kennelmanagercompose.domain.models.events.HousingLog
import com.example.kennelmanagercompose.domain.models.events.extenions.overlaps
import com.example.kennelmanagercompose.domain.models.events.extenions.wasDogInCageAt
import com.example.kennelmanagercompose.pooptracking.domain.models.ExcrementLog
import com.example.kennelmanagercompose.pooptracking.domain.models.PoopScore
import java.time.Instant

class PoopCalculator(
    private val allLogs: List<ExcrementLog>,
    private val allHousing: List<HousingLog>,
    private val start: Instant,
    private val end: Instant
) {
    // 1. Pre-filter logs to the time window for performance
    private val logsInWindow = allLogs.filter { it.date in start..end }

    /**
     * Main entry point: Returns 0.0 to 100.0 health for a dog.
     */
    fun getHealthIndex(dogId: String): Double {
        val relevantLogs = getRelevantLogsForDog(dogId)
        if (relevantLogs.isEmpty()) return 100.0

        val totalWeightedImpact = relevantLogs.sumOf {
            PoopMath.getWeightedImpact(it.poopScore.score)
        }

        return PoopMath.calculateHealthPercentage(totalWeightedImpact / relevantLogs.size)
    }

    /**
     * Gets the single latest score (used for the 'Hard' color override).
     */
    fun getLatestScore(dogId: String): PoopScore? {
        return getRelevantLogsForDog(dogId).maxByOrNull { it.date }?.poopScore
    }

    private fun getRelevantLogsForDog(dogId: String): List<ExcrementLog> {
        // Find all cage-stays for this dog that overlap with our time window
        val stays = allHousing.filter { stay ->
            stay.dogId == dogId &&
                    stay.movedInAt < end &&
                    (stay.movedOutAt == null || stay.movedOutAt!! > start)
        }

        return logsInWindow.filter { log ->
            // Direct match
            if (log.dogId == dogId) return@filter true

            // Cage match: Was the dog in this cage when the log was created?
            stays.any { stay ->
                log.cageId == stay.cageId &&
                        log.date >= stay.movedInAt &&
                        (stay.movedOutAt == null || log.date <= stay.movedOutAt!!)
            }
        }
    }
}