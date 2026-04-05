package com.example.kennelmanagercompose.dog.medical.ui.colormappers

import androidx.compose.ui.graphics.Color
import com.example.kennelmanagercompose.dog.medical.enums.Severity
import com.example.kennelmanagercompose.draggablemap.core.ui.themes.KennelTheme
import com.example.kennelmanagercompose.draggablemap.maplens.ui.themes.DefaultTheme

fun Severity.toColor(theme: DefaultTheme = KennelTheme.default) : Color = when(this) {
    Severity.INFO -> theme.best
    Severity.UNKNOWN -> theme.good
    Severity.LOW -> theme.okay
    Severity.HIGH -> theme.bad
    Severity.CRITICAL -> theme.worst
}