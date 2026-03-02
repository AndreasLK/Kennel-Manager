package com.example.kennelmanagercompose.domain.models.events

import com.example.kennelmanagercompose.core.Entity
import java.time.Instant
import java.util.UUID

data class FightLog(
    override val id: String = UUID.randomUUID().toString(),
    val time: Instant,
    val dogs: List<String>, //List of dog
    val description: String
) : Entity