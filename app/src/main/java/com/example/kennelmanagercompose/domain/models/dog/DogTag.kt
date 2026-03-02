package com.example.kennelmanagercompose.domain.models.dog

import com.android.identity.util.UUID
import com.example.kennelmanagercompose.core.Entity

data class DogTag(
    override val id: String = UUID.randomUUID().toString(),
    val name: String,
    val color: Long,
    val staffId: String
) : Entity
