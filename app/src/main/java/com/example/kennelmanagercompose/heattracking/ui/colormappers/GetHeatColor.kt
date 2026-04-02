package com.example.kennelmanagercompose.heattracking.ui.colormappers

import androidx.compose.ui.graphics.Color
import com.example.kennelmanagercompose.heattracking.domain.models.Heat
import com.example.kennelmanagercompose.ui.theme.KennelTheme
import com.example.kennelmanagercompose.heattracking.ui.themes.HeatTheme

fun Heat.toColor(theme: HeatTheme = KennelTheme.heat) : Color = when(this){
        Heat.NOT_IN_HEAT -> theme.notInHeat
        Heat.EXPECTED_IN_HEAT -> theme.calculatedHeat
        Heat.COMING_IN_HEAT -> theme.comingInHeat
        Heat.STANDING_HEAT -> theme.standingHeat
        Heat.GOING_OUT_OF_HEAT -> theme.goingOutOfHeat
}
