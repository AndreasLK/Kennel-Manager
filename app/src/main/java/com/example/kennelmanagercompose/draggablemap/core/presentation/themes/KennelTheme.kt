package com.example.kennelmanagercompose.draggablemap.core.presentation.themes

import com.example.kennelmanagercompose.dog.presentation.themes.BodyScoreTheme
import com.example.kennelmanagercompose.dog.presentation.themes.HeatTheme
import com.example.kennelmanagercompose.dog.presentation.themes.MissedMealsTheme
import com.example.kennelmanagercompose.dog.presentation.themes.PoopScoreTheme
import com.example.kennelmanagercompose.dog.presentation.themes.RunStatusTheme
import com.example.kennelmanagercompose.draggablemap.maplens.ui.themes.DefaultTheme

object KennelTheme {
    var default = DefaultTheme()
    var poop = PoopScoreTheme()
    var bodyScore = BodyScoreTheme()
    var missedMeals = MissedMealsTheme()
    var runStatus = RunStatusTheme()
    var heat = HeatTheme()

}