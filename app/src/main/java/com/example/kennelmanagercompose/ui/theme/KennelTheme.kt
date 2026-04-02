package com.example.kennelmanagercompose.ui.theme

import com.example.kennelmanagercompose.ui.theme.sub.BodyScoreTheme
import com.example.kennelmanagercompose.ui.theme.sub.DefaultTheme
import com.example.kennelmanagercompose.ui.theme.sub.MissedMealsTheme
import com.example.kennelmanagercompose.heattracking.ui.themes.HeatTheme
import com.example.kennelmanagercompose.pooptracking.ui.themes.PoopScoreTheme
import com.example.kennelmanagercompose.ui.theme.sub.RunStatusTheme

object KennelTheme {
    var default = DefaultTheme()
    var poop = PoopScoreTheme()
    var bodyScore = BodyScoreTheme()
    var missedMeals = MissedMealsTheme()
    var runStatus = RunStatusTheme()
    var heat = HeatTheme()

}