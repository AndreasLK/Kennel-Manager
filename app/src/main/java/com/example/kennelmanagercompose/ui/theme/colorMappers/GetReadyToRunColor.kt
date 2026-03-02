package com.example.kennelmanagercompose.ui.theme.colorMappers

import androidx.compose.ui.graphics.Color
import com.example.kennelmanagercompose.domain.enums.RunStatus
import com.example.kennelmanagercompose.ui.theme.KennelTheme
import com.example.kennelmanagercompose.ui.theme.sub.RunStatusTheme

fun RunStatus.toColor(theme: RunStatusTheme = KennelTheme.runStatus) : Color = when(this){
    RunStatus.CANT_RUN -> theme.cantRun
    RunStatus.SHOULDNT_RUN -> theme.shouldntRun
    RunStatus.CAN_RUN -> theme.canRun
    RunStatus.SHOULD_RUN -> theme.shouldRun
    RunStatus.NEEDS_TO_RUN -> theme.needsToRun
}