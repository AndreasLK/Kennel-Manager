package com.example.kennelmanagercompose.dog.domain.config

import com.example.kennelmanagercompose.core.AppConfig

data class WorkRules(
    val minRunAgeMonths: Int = AppConfig.DEFAULT_WORK_MIN_AGE_MONTHS,
    val younglingAgeMonths: Int = AppConfig.DEFAULT_WORK_YOUNGLING_AGE_MONTHS,
    val maxYounglingSessions: Int = AppConfig.DEFAULT_WORK_MAX_YOUNGLING_SESSIONS,

    val oldAgeMonths: Int = AppConfig.DEFAULT_WORK_OLDIE_AGE_MONTHS,
    val maxOldAgeSessions: Int = AppConfig.DEFAULT_WORK_MAX_OLDIE_SESSIONS

)
