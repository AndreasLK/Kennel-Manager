package com.example.kennelmanagercompose.ui.theme.colorMappers

import androidx.compose.ui.graphics.Color
import com.example.kennelmanagercompose.domain.enums.Severity
import com.example.kennelmanagercompose.ui.theme.KennelTheme
import com.example.kennelmanagercompose.ui.theme.sub.DefaultTheme

fun Severity.toColor(theme: DefaultTheme = KennelTheme.default) : Color = when(this) {
    Severity.INFO -> theme.best
    Severity.UNKNOWN -> theme.good
    Severity.LOW -> theme.okay
    Severity.HIGH -> theme.bad
    Severity.CRITICAL -> theme.worst
}