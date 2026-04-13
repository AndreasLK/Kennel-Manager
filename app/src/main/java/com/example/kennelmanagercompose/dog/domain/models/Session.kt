package com.example.kennelmanagercompose.dog.domain.models

import com.example.kennelmanagercompose.core.domain.interfaces.Entity
import com.example.kennelmanagercompose.dog.domain.enums.SessionStatus
import java.util.UUID

data class Session(
    override val id: String = UUID.randomUUID().toString(),
    val status: SessionStatus,
    val dogTeam: DogTeam,
    val startTime: String,
    val endTime: String,
    val distanceKm: Float,
    val gpxURL: String? = null,
    val description: String,
    val staffId: String
    ) : Entity