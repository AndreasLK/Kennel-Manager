package com.example.kennelmanagercompose.dog.session.domain.models

import com.example.kennelmanagercompose.core.domain.interfaces.Entity
import java.util.UUID

data class DogTeam(
    override val id: String = UUID.randomUUID().toString(),
    val name: String,
    val members: List<String>, //Dog ids
    val description: String
): Entity