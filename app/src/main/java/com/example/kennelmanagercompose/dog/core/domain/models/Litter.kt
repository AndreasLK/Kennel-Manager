package com.example.kennelmanagercompose.dog.core.domain.models

import com.example.kennelmanagercompose.core.domain.interfaces.Entity
import java.util.UUID

data class Litter(
    override val id: String = UUID.randomUUID().toString(),
    val motherId: String,
    val fatherId: String,
    val description: String
) : Entity