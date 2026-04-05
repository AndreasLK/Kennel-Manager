package com.example.kennelmanagercompose.dog.core.domain.enums

enum class DogStatus(
    val showActive: Boolean, //Active + Show on team builder screen
    val showInKennel: Boolean //Physically in kennel
) {
    ACTIVE(showActive = true, showInKennel = true),
    INACTIVE(showActive = false, showInKennel = true),
    REHOMED(showActive = false, showInKennel = false),
    SOLD(showActive = false, showInKennel = false),
    DECEASED(showActive = false, showInKennel = false),
    UNKNOWN(showActive = false, showInKennel = false);
}