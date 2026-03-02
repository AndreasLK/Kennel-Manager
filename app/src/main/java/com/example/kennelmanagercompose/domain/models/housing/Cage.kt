package com.example.kennelmanagercompose.domain.models.housing

import com.example.kennelmanagercompose.core.Entity
import java.util.UUID

data class Cage(
    override val id: String =  UUID.randomUUID().toString(),
    val rowName: String,
    val maxCapacity: Int,
    val mapX: Float,
    val mapY: Float,
    val scaleX: Float =1f,
    val scaleY: Float =1f,
    val longitude: Double,
    val latitude: Double,
    val dogsInside: List<String> = emptyList(), //List of dog IDs
    val description: String
) : Entity