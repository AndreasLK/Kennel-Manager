package com.example.kennelmanagercompose.dog.domain.models.logs

import com.example.kennelmanagercompose.core.domain.interfaces.Entity
import com.example.kennelmanagercompose.dog.domain.enums.PoopScore
import java.time.Instant
import java.util.UUID

data class ExcrementLog(
    override val id: String =  UUID.randomUUID().toString(),
    val dogId : String? = null,
    val cageId: String? = null,
    val date : Instant = Instant.now(),
    val poopScore: PoopScore,
    val description: String? = null,
    val photoURL: String? = null,
    val staffId : String
) : Entity