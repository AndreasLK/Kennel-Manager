package com.example.kennelmanagercompose.core

import androidx.compose.ui.unit.dp

object AppConfig {
    // --- UI CONFIG (Keep here, usually static) ---
    val DEFAULT_WINDOW_WIDTH = 200.dp
    val DEFAULT_WINDOW_HEIGHT = 160.dp
    const val SNAP_THRESHOLD = 3f

    // --- LOGIC DEFAULTS (Read-only reference values) ---
    const val DEFAULT_RUN_HISTORY_DAYS = 10

    const val DEFAULT_SCORE_CANT_RUN = -50
    const val DEFAULT_SCORE_SHOULDNT_RUN = -10
    const val DEFAULT_SCORE_CAN_RUN = 20
    const val DEFAULT_SCORE_SHOULD_RUN = 50

    const val DEFAULT_MAX_WORK_DAYS = 4
    const val DEFAULT_MAX_OFF_DAYS = 3

    const val DEFAULT_FATIGUE_PENALTY = 5
    const val DEFAULT_RECENT_FATIGUE_PENALTY = 10


    // --- WORK RULES DEFAULTS (Age & Safety) ---
    const val DEFAULT_WORK_MIN_AGE_MONTHS = 12       // 1 Year
    const val DEFAULT_WORK_YOUNGLING_AGE_MONTHS = 24 // 2 Years
    const val DEFAULT_WORK_MAX_YOUNGLING_SESSIONS = 1 // 1 Run max per day
    const val DEFAULT_WORK_OLDIE_AGE_MONTHS = 96     // 8 Years
    const val DEFAULT_WORK_MAX_OLDIE_SESSIONS = 2     // 2 Runs max per day


    const val DEFAULT_PLANNING_HOUR = 18
}