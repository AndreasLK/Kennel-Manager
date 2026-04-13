package com.example.kennelmanagercompose.draggablemap.core.presentation.models

import com.example.kennelmanagercompose.dog.domain.models.Dog

sealed interface WindowContent {
    // Updated to include dogs for lens rendering
    data class KennelOverview(val row: String, val dogs: List<Dog> = emptyList()) : WindowContent
    data class SystemAlert(val message: String) : WindowContent
}