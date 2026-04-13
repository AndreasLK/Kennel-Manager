package com.example.kennelmanagercompose.dog.domain.config

data class DogWorkOverrides(
    val minRunAgeMonths: Int? = null,
    val younglingAgeMonths: Int? = null,

    val maxSessionsPerDay: Int? = null,

    val maxWorkDaysInARow: Int? = null,
)
