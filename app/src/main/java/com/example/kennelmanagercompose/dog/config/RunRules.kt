package com.example.kennelmanagercompose.dog.config

import com.example.kennelmanagercompose.core.AppConfig

data class RunRules(
    // --- Limits & Thresholds ---
    val maxWorkDaysInARow: Int = AppConfig.DEFAULT_MAX_WORK_DAYS,
    val maxOffDaysInARow: Int = AppConfig.DEFAULT_MAX_OFF_DAYS,
    val historyDays: Int = AppConfig.DEFAULT_RUN_HISTORY_DAYS,
    val planningHour: Int = AppConfig.DEFAULT_PLANNING_HOUR,


    // --- Scoring Thresholds (The Color Buckets) ---
    val scoreCantRun: Int = AppConfig.DEFAULT_SCORE_CANT_RUN,       // -50
    val scoreShouldntRun: Int = AppConfig.DEFAULT_SCORE_SHOULDNT_RUN, // -10
    val scoreCanRun: Int = AppConfig.DEFAULT_SCORE_CAN_RUN,           // 20
    val scoreShouldRun: Int = AppConfig.DEFAULT_SCORE_SHOULD_RUN,     // 50

    // --- Math Penalties ---
    val fatiguePenaltyPerDay: Int = AppConfig.DEFAULT_FATIGUE_PENALTY,
    val recentFatiguePenalty: Int = AppConfig.DEFAULT_RECENT_FATIGUE_PENALTY
)