package com.example.kennelmanagercompose.draggablemap.maplens.ui.themes

import androidx.compose.ui.graphics.Color
import com.example.kennelmanagercompose.dog.presentation.colormappers.toColor
import com.example.kennelmanagercompose.draggablemap.maplens.domain.enums.MapLens
import com.example.kennelmanagercompose.draggablemap.core.domain.interfaces.KennelStateProvider
import com.example.kennelmanagercompose.dog.domain.models.Dog

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