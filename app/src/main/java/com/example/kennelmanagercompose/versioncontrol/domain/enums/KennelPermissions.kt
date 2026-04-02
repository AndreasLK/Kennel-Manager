package com.example.kennelmanagercompose.versioncontrol.domain.enums

enum class KennelPermissions {
    AUTO_APPROVE_IDENTITY,   // Name, Breed
    AUTO_APPROVE_GEOMETRY,   // Moving Cages
    AUTO_APPROVE_MEDICAL,    // Vaccine/Vet logs
    AUTO_APPROVE_OPERATIONAL,// Poop/Feeding logs
    AUTO_APPROVE_PEDIGREE,   // Family relations
    MANAGE_PERMISSIONS       // Ability to grant these to others
}