package com.example.kennelmanagercompose.domain.models.breeding

import com.example.kennelmanagercompose.core.Entity
import java.util.UUID

data class Litter(
    override val id: String = UUID.randomUUID().toString(),
    val motherId: String,
    val fatherId: String,
    val description: String
) : Entity