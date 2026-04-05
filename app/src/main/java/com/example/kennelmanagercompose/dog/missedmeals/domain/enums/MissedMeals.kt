package com.example.kennelmanagercompose.dog.missedmeals.domain.enums

enum class MissedMeals {
    DID_EAT,
    MISSED_1,
    MISSED_2,
    MISSED_3,
    MISSED_4,
    CRITICAL;

    companion object {
        fun fromInt(daysSinceLastMeal: Int?) : MissedMeals {
            return when (daysSinceLastMeal) {
                0   -> DID_EAT
                1   -> MISSED_1
                2   -> MISSED_2
                3   -> MISSED_3
                4   -> MISSED_4
                else -> CRITICAL
            }
        }
    }
}