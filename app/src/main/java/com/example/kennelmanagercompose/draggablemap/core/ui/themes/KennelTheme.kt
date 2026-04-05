package com.example.kennelmanagercompose.draggablemap.core.ui.themes

import com.example.kennelmanagercompose.dog.bodyscore.ui.themes.BodyScoreTheme
import com.example.kennelmanagercompose.dog.heat.ui.themes.HeatTheme
import com.example.kennelmanagercompose.dog.missedmeals.ui.themes.MissedMealsTheme
import com.example.kennelmanagercompose.dog.poop.ui.themes.PoopScoreTheme
import com.example.kennelmanagercompose.dog.session.ui.themes.RunStatusTheme
import com.example.kennelmanagercompose.draggablemap.maplens.ui.themes.DefaultTheme

object KennelTheme {
    var default = DefaultTheme()
    var poop = PoopScoreTheme()
    var bodyScore = BodyScoreTheme()
    var missedMeals = MissedMealsTheme()
    var runStatus = RunStatusTheme()
    var heat = HeatTheme()

}