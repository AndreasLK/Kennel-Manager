package com.example.kennelmanagercompose.ui.theme.colorMappers

import androidx.compose.ui.graphics.Color
import com.example.kennelmanagercompose.domain.enums.MapLens
import com.example.kennelmanagercompose.domain.interfaces.KennelStateProvider
import com.example.kennelmanagercompose.domain.models.dog.Dog
import com.example.kennelmanagercompose.pooptracking.ui.colormappers.toColor

object MapLensColorMapper {
    fun mapColor(
        lens: MapLens,
        dog: Dog,
        state: KennelStateProvider
    ): Color {
        return when (lens) {
            MapLens.FEEDING -> state.getMissedMeals(dogId = dog.id).toColor()
            MapLens.POOP -> state.getLatestPoopScore(dogId = dog.id).toColor()
            MapLens.HEAT -> state.getHeatStatus(dogId = dog.id).toColor()
            MapLens.MEDICAL -> state.getMedicalStatus(dogId = dog.id).toColor()
            MapLens.BODYSCORE -> state.getBodyScore(dogId = dog.id).toColor()
            MapLens.READY_TO_RUN -> state.getRunStatus(dogId = dog.id).toColor()
        }
    }
}