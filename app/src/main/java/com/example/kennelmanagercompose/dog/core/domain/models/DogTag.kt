package com.example.kennelmanagercompose.dog.core.domain.models

import com.android.identity.util.UUID
import com.example.kennelmanagercompose.core.domain.interfaces.Entity

data class DogTag(
    override val id: String = UUID.randomUUID().toString(),
    val name: String,
    val color: Long,
    val staffId: String
) : Entity
