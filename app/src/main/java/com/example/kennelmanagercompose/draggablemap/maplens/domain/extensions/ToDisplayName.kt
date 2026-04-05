package com.example.kennelmanagercompose.draggablemap.maplens.domain.extensions

fun String.toDisplayName(): String {
    return this.split("_").joinToString(" ") { word ->
        word.lowercase().replaceFirstChar { it.uppercaseChar() }
    }
}