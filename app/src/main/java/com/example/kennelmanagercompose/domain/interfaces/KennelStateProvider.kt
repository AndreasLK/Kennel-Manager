package com.example.kennelmanagercompose.domain.interfaces

import com.example.kennelmanagercompose.domain.enums.BodyScore
import com.example.kennelmanagercompose.heattracking.domain.models.Heat
import com.example.kennelmanagercompose.domain.enums.MissedMeals
import com.example.kennelmanagercompose.pooptracking.domain.models.PoopScore
import com.example.kennelmanagercompose.domain.enums.RunStatus
import com.example.kennelmanagercompose.domain.enums.Severity

interface KennelStateProvider {
    fun getMissedMeals(dogId: String): MissedMeals
    fun getLatestPoopScore(dogId: String): PoopScore
    fun getHeatStatus(dogId: String): Heat
    fun getMedicalStatus(dogId: String): Severity
    fun getBodyScore(dogId: String) : BodyScore

    fun getRunStatus(dogId: String): RunStatus
    fun getVaccineStatus(dogId: String): Severity
}