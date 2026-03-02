package com.example.kennelmanagercompose.pooptracking.ui.colormappers

import androidx.compose.ui.graphics.Color
import com.example.kennelmanagercompose.pooptracking.domain.models.PoopScore
import com.example.kennelmanagercompose.ui.theme.KennelTheme
import com.example.kennelmanagercompose.pooptracking.ui.themes.PoopScoreTheme

fun PoopScore.toColor(theme: PoopScoreTheme = KennelTheme.poop): Color = when(this) {
        PoopScore.HARD -> theme.hard
        PoopScore.FIRM -> theme.firm
        PoopScore.LOG -> theme.log
        PoopScore.SOGGY -> theme.soggy
        PoopScore.MOIST -> theme.moist
        PoopScore.THIN -> theme.thin
        PoopScore.WATERY -> theme.watery
}