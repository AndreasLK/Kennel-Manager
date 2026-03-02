package com.example.kennelmanagercompose.pooptracking.domain.models

import com.example.kennelmanagercompose.core.Entity
import com.example.kennelmanagercompose.pooptracking.domain.models.PoopScore
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