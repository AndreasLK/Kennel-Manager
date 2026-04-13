package com.example.kennelmanagercompose.dog.domain.models.logs

import com.example.kennelmanagercompose.core.domain.interfaces.Entity
import java.time.Instant
import java.util.UUID

data class HousingLog(
    override val id: String = UUID.randomUUID().toString(),
    val dogId: String,
    val cageId: String,
    val movedInAt: Instant = Instant.now(),
    var movedOutAt: Instant? = null // When null, the dog is currently "In" this cage
) : Entity