package com.example.kennelmanagercompose.dog.presentation.colormappers

import androidx.compose.ui.graphics.Color
import com.example.kennelmanagercompose.dog.domain.enums.Severity
import com.example.kennelmanagercompose.draggablemap.core.presentation.themes.KennelTheme
import com.example.kennelmanagercompose.draggablemap.maplens.ui.themes.DefaultTheme

fun Severity.toColor(theme: DefaultTheme = KennelTheme.default) : Color = when(this) {
    Severity.INFO -> theme.best
    Severity.UNKNOWN -> theme.good
    Severity.LOW -> theme.okay
    Severity.HIGH -> theme.bad
    Severity.CRITICAL -> theme.worst
}