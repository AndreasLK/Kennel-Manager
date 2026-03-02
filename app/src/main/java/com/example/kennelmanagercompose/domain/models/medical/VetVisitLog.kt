package com.example.kennelmanagercompose.domain.models.medical

import com.example.kennelmanagercompose.core.Entity
import java.time.Instant
import java.util.UUID

data class VetVisitLog(
    override val id: String =  UUID.randomUUID().toString(),
    val date: Instant,
    val dogs: List<String>, //List of dog IDs
    val description: String
) : Entity
