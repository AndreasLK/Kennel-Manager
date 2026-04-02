package com.example.kennelmanagercompose.versioncontrol.domain.enums

enum class ChangeTarget {
    DOG_CORE, //Name, Breed, Gender, Sterilization
    CAGE_CORE, //Row, Dimensions, Position
    VACCINE,        // Medical logs
    VET_VISIT,      // Medical logs
    POOP_SCORE,     // Excrement logs
    HOUSING_LOG,    // Cage assignments
    PEDIGREE        // Family/Litter relations
}