package com.example.kennelmanagercompose.domain.models.dog

import com.android.identity.util.UUID
import com.example.kennelmanagercompose.core.Entity

data class DogTeam(
    override val id: String = UUID.randomUUID().toString(),
    val name: String,
    val members: List<String>, //Dog ids
    val description: String
): Entity
