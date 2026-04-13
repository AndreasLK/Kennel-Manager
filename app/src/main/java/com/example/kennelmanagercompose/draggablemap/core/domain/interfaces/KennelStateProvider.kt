package com.example.kennelmanagercompose.draggablemap.core.domain.interfaces

import com.example.kennelmanagercompose.dog.domain.enums.BodyScore
import com.example.kennelmanagercompose.dog.domain.enums.MissedMeals
import com.example.kennelmanagercompose.dog.domain.enums.Severity
import com.example.kennelmanagercompose.dog.domain.enums.Heat
import com.example.kennelmanagercompose.dog.domain.enums.PoopScore
import com.example.kennelmanagercompose.dog.domain.enums.RunStatus

interface KennelStateProvider {
    fun getMissedMeals(dogId: String): MissedMeals
    fun getLatestPoopScore(dogId: String): PoopScore
    fun getHeatStatus(dogId: String): Heat
    fun getMedicalStatus(dogId: String): Severity
    fun getBodyScore(dogId: String) : BodyScore

    fun getRunStatus(dogId: String): RunStatus
    fun getVaccineStatus(dogId: String): Severity
}