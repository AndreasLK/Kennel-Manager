package com.example.kennelmanagercompose.dog.presentation.colormappers

import androidx.compose.ui.graphics.Color
import com.example.kennelmanagercompose.dog.domain.enums.MissedMeals
import com.example.kennelmanagercompose.draggablemap.core.ui.themes.KennelTheme
import com.example.kennelmanagercompose.dog.presentation.themes.MissedMealsTheme

fun MissedMeals.toColor(theme: MissedMealsTheme = KennelTheme.missedMeals) : Color = when(this){
    MissedMeals.DID_EAT -> theme.didEat
    MissedMeals.MISSED_1 -> theme.missed1
    MissedMeals.MISSED_2 -> theme.missed2
    MissedMeals.MISSED_3 -> theme.missed3
    MissedMeals.MISSED_4 -> theme.missed4
    MissedMeals.CRITICAL -> theme.critical
}
