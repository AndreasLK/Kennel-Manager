package com.example.kennelmanagercompose.domain.enums

import com.example.kennelmanagercompose.domain.models.dog.Dog

enum class MapLens(val displayName: String) {
    READY_TO_RUN("Ready to Run"),
    FEEDING("Feeding"),
    POOP("Poop Score"),
    BODYSCORE("Bodyscore"),
    HEAT("Heat Watch"),
    MEDICAL("Medical");

}