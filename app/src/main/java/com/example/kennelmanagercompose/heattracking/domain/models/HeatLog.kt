package com.example.kennelmanagercompose.heattracking.domain.models

import com.example.kennelmanagercompose.core.Entity
import java.time.LocalDate

data class HeatLog(
    override val id: String,
    val dogId: String,
    val startDate: LocalDate, //Day heat is discovered
    val endDate: LocalDate? = null, //Day heat is cleared
    val notes: String? = null
): Entity