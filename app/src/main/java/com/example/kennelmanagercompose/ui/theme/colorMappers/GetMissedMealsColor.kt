package com.example.kennelmanagercompose.ui.theme.colorMappers

import androidx.compose.ui.graphics.Color
import com.example.kennelmanagercompose.domain.enums.MissedMeals
import com.example.kennelmanagercompose.ui.theme.KennelTheme
import com.example.kennelmanagercompose.ui.theme.sub.MissedMealsTheme

fun MissedMeals.toColor(theme: MissedMealsTheme = KennelTheme.missedMeals) : Color = when(this){
    MissedMeals.DID_EAT -> theme.didEat
    MissedMeals.MISSED_1 -> theme.missed1
    MissedMeals.MISSED_2 -> theme.missed2
    MissedMeals.MISSED_3 -> theme.missed3
    MissedMeals.MISSED_4 -> theme.missed4
    MissedMeals.CRITICAL -> theme.critical
}
