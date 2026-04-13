package com.example.kennelmanagercompose.dog.presentation.colormappers

import androidx.compose.ui.graphics.Color
import com.example.kennelmanagercompose.dog.domain.enums.BodyScore
import com.example.kennelmanagercompose.draggablemap.core.presentation.themes.KennelTheme
import com.example.kennelmanagercompose.dog.presentation.themes.BodyScoreTheme

fun BodyScore.toColor(theme: BodyScoreTheme = KennelTheme.bodyScore) : Color = when(this){
    BodyScore.VERY_THIN -> theme.veryThin
    BodyScore.THIN -> theme.thin
    BodyScore.IDEAL -> theme.ideal
    BodyScore.THICK -> theme.thick
    BodyScore.OBESE -> theme.obese
    BodyScore.UNKNOWN -> theme.unknown
}