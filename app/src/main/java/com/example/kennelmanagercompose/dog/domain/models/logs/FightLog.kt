package com.example.kennelmanagercompose.dog.domain.models.logs

import com.example.kennelmanagercompose.core.domain.interfaces.Entity
import java.time.Instant
import java.util.UUID

data class FightLog(
    override val id: String = UUID.randomUUID().toString(),
    val time: Instant,
    val dogs: List<String>, //List of dog
    val description: String
) : Entity