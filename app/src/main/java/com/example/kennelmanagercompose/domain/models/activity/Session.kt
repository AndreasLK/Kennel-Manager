package com.example.kennelmanagercompose.domain.models.activity

import com.example.kennelmanagercompose.core.Entity
import com.example.kennelmanagercompose.domain.enums.SessionStatus
import com.example.kennelmanagercompose.domain.models.dog.DogTeam
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