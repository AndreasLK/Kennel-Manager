package com.example.kennelmanagercompose.dog.presentation.colormappers

import androidx.compose.ui.graphics.Color
import com.example.kennelmanagercompose.dog.domain.enums.Heat
import com.example.kennelmanagercompose.draggablemap.core.presentation.themes.KennelTheme
import com.example.kennelmanagercompose.dog.presentation.themes.HeatTheme

fun Heat.toColor(theme: HeatTheme = KennelTheme.heat) : Color = when(this){
        Heat.NOT_IN_HEAT -> theme.notInHeat
        Heat.EXPECTED_IN_HEAT -> theme.calculatedHeat
        Heat.COMING_IN_HEAT -> theme.comingInHeat
        Heat.STANDING_HEAT -> theme.standingHeat
        Heat.GOING_OUT_OF_HEAT -> theme.goingOutOfHeat
}
