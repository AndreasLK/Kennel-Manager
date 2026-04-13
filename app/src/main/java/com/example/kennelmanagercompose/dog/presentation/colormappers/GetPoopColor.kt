package com.example.kennelmanagercompose.dog.presentation.colormappers

import androidx.compose.ui.graphics.Color
import com.example.kennelmanagercompose.dog.domain.enums.PoopScore
import com.example.kennelmanagercompose.draggablemap.core.presentation.themes.KennelTheme
import com.example.kennelmanagercompose.dog.presentation.themes.PoopScoreTheme

fun PoopScore.toColor(theme: PoopScoreTheme = KennelTheme.poop): Color = when(this) {
        PoopScore.HARD -> theme.hard
        PoopScore.FIRM -> theme.firm
        PoopScore.LOG -> theme.log
        PoopScore.SOGGY -> theme.soggy
        PoopScore.MOIST -> theme.moist
        PoopScore.THIN -> theme.thin
        PoopScore.WATERY -> theme.watery
}