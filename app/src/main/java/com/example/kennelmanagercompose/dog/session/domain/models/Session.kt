package com.example.kennelmanagercompose.dog.session.domain.models

import com.example.kennelmanagercompose.core.domain.interfaces.Entity
import java.util.UUID

data class Session(
    override val id: String = UUID.randomUUID().toString(),
    val status: com.example.kennelmanagercompose.dog.session.domain.enums.SessionStatus,
    val dogTeam: com.example.kennelmanagercompose.dog.session.domain.models.DogTeam,
    val startTime: String,
    val endTime: String,
    val distanceKm: Float,
    val gpxURL: String? = null,
    val description: String,
    val staffId: String
    ) : Entity