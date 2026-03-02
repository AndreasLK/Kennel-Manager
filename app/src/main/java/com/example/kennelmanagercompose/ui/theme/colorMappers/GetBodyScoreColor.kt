package com.example.kennelmanagercompose.ui.theme.colorMappers

import androidx.compose.ui.graphics.Color
import com.example.kennelmanagercompose.domain.enums.BodyScore
import com.example.kennelmanagercompose.ui.theme.KennelTheme
import com.example.kennelmanagercompose.ui.theme.sub.BodyScoreTheme

fun BodyScore.toColor(theme: BodyScoreTheme = KennelTheme.bodyScore) : Color = when(this){
    BodyScore.VERY_THIN -> theme.veryThin
    BodyScore.THIN -> theme.thin
    BodyScore.IDEAL -> theme.ideal
    BodyScore.THICK -> theme.thick
    BodyScore.OBESE -> theme.obese
    BodyScore.UNKNOWN -> theme.unknown
}