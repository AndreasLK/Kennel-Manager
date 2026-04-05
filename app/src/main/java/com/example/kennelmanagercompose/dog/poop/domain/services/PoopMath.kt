package com.example.kennelmanagercompose.dog.poop.domain.services

import kotlin.math.abs

object PoopMath {
    /**
     * Maps Royal Canin 1-7 to a relative "Distance from Ideal".
     * Ideal (2) is 0. Watery (7) is -5. Hard (1) is -1.
     */
    private fun getRawImpact(score: Int): Double {
        return when (score) {
            2 -> 0.0          // Ideal (Firm)
            1, 3 -> -1.0      // Hard or Log
            4 -> -2.0         // Soggy
            5 -> -3.0         // Moist
            6 -> -4.0         // Thin
            7 -> -5.0         // Watery
            else -> 0.0
        }
    }

    /**
     * The X * |X| logic.
     * Squares the penalty so Score 7 (-5) becomes -25.
     */
    fun getWeightedImpact(score: Int): Double {
        val x = getRawImpact(score)
        return x * abs(x)
    }

    /**
     * Converts a weighted average (-25.0 to 0.0) into a 0-100% Health Index.
     */
    fun calculateHealthPercentage(averageWeightedImpact: Double): Double {
        return ((averageWeightedImpact + 25.0) / 25.0 * 100.0).coerceIn(0.0, 100.0)
    }
}