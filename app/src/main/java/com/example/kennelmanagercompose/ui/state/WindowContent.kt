package com.example.kennelmanagercompose.ui.state

import com.example.kennelmanagercompose.domain.models.dog.Dog

sealed interface WindowContent {
    // Updated to include dogs for lens rendering
    data class KennelOverview(val row: String, val dogs: List<Dog> = emptyList()) : WindowContent
    data class SystemAlert(val message: String) : WindowContent
}