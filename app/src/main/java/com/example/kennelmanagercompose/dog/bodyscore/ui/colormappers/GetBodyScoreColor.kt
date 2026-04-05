package com.example.kennelmanagercompose.dog.bodyscore.ui.colormappers

import androidx.compose.ui.graphics.Color
import com.example.kennelmanagercompose.dog.bodyscore.domain.enums.BodyScore
import com.example.kennelmanagercompose.draggablemap.core.ui.themes.KennelTheme
import com.example.kennelmanagercompose.dog.bodyscore.ui.themes.BodyScoreTheme

fun BodyScore.toColor(theme: BodyScoreTheme = KennelTheme.bodyScore) : Color = when(this){
    BodyScore.VERY_THIN -> theme.veryThin
    BodyScore.THIN -> theme.thin
    BodyScore.IDEAL -> theme.ideal
    BodyScore.THICK -> theme.thick
    BodyScore.OBESE -> theme.obese
    BodyScore.UNKNOWN -> theme.unknown
}