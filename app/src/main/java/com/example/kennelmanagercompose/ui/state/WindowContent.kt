package com.example.kennelmanagercompose.ui.state

import com.example.kennelmanagercompose.domain.models.dog.Dog

sealed interface WindowContent {
    data class DogProfile(val dog: Dog) : WindowContent

    data class KennelOverview(val row: String) : WindowContent

    data class SystemAlert(val message: String) : WindowContent
}