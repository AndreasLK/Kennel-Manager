package com.example.kennelmanagercompose.dog.presentation.colormappers

import androidx.compose.ui.graphics.Color
import com.example.kennelmanagercompose.dog.domain.enums.RunStatus
import com.example.kennelmanagercompose.dog.presentation.themes.RunStatusTheme

import com.example.kennelmanagercompose.draggablemap.core.presentation.themes.KennelTheme

fun RunStatus.toColor(theme: RunStatusTheme = KennelTheme.runStatus) : Color = when(this){
    RunStatus.CANT_RUN -> theme.cantRun
    RunStatus.SHOULDNT_RUN -> theme.shouldntRun
    RunStatus.CAN_RUN -> theme.canRun
    RunStatus.SHOULD_RUN -> theme.shouldRun
    RunStatus.NEEDS_TO_RUN -> theme.needsToRun
}