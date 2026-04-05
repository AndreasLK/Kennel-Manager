package com.example.kennelmanagercompose.draggablemap.core.domain.interfaces

import com.example.kennelmanagercompose.dog.bodyscore.domain.enums.BodyScore
import com.example.kennelmanagercompose.dog.missedmeals.domain.enums.MissedMeals
import com.example.kennelmanagercompose.dog.medical.enums.Severity
import com.example.kennelmanagercompose.dog.heat.domain.models.Heat
import com.example.kennelmanagercompose.dog.poop.domain.models.PoopScore
import com.example.kennelmanagercompose.dog.session.domain.enums.RunStatus

interface KennelStateProvider {
    fun getMissedMeals(dogId: String): MissedMeals
    fun getLatestPoopScore(dogId: String): PoopScore
    fun getHeatStatus(dogId: String): Heat
    fun getMedicalStatus(dogId: String): Severity
    fun getBodyScore(dogId: String) : BodyScore

    fun getRunStatus(dogId: String): RunStatus
    fun getVaccineStatus(dogId: String): Severity
}