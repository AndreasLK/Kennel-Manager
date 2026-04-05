package com.example.kennelmanagercompose.dog.medical.enums

enum class Severity(val level: Int) {
    UNKNOWN(0),
    INFO(1),
    LOW(2),
    HIGH(3),
    CRITICAL(4)
}