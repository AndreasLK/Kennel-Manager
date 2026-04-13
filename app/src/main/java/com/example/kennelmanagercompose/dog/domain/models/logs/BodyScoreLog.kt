package com.example.kennelmanagercompose.dog.domain.models.logs

import com.example.kennelmanagercompose.core.domain.interfaces.Entity
import com.example.kennelmanagercompose.dog.domain.enums.BodyScore
import java.time.Instant
import java.util.UUID

data class BodyScoreLog(
    override val id: String =  UUID.randomUUID().toString(),
    val dogId: String,
    val date : Instant = Instant.now(),
    val bodyScore: BodyScore,
    val description: String,
    val photoURL: String? = null,
    val staffId : String
) : Entity