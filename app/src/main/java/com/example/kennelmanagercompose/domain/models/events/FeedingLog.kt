package com.example.kennelmanagercompose.domain.models.events

import com.example.kennelmanagercompose.core.Entity
import java.time.Instant
import java.util.UUID

data class FeedingLog(
    override val id: String =  UUID.randomUUID().toString(),
    val dogIds: List<String>,
    val date: Instant = Instant.now(),
    val didEat: Boolean = false,
    val description: String,
    val staffId: String //Staff ID
) : Entity
