package com.example.kennelmanagercompose.dog.domain.models.logs

import com.example.kennelmanagercompose.core.domain.interfaces.Entity
import java.time.Instant
import java.util.UUID

data class VaccineLog(
    override val id: String =  UUID.randomUUID().toString(),
    val name: String,
    val dateOfVaccines: Instant,
    val dateEffectiveBy: Instant,
    val dateOfExpiration: Instant,
    val dogID: String, //Dog ID
    val description: String
) : Entity
