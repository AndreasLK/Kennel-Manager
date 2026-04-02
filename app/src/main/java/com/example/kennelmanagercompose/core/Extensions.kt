package com.example.kennelmanagercompose.core

fun String.toDisplayName(): String {
    return this.split("_").joinToString(" ") { word ->
        word.lowercase().replaceFirstChar { it.uppercaseChar() }
    }
}