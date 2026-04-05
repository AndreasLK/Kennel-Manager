package com.example.kennelmanagercompose.dog.medical.models

import com.example.kennelmanagercompose.core.domain.interfaces.Entity
import java.time.Instant
import java.util.UUID

data class VetVisitLog(
    override val id: String =  UUID.randomUUID().toString(),
    val date: Instant,
    val dogs: List<String>, //List of dog IDs
    val description: String
) : Entity
