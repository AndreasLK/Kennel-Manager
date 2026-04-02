package com.example.kennelmanagercompose.ui.theme.colorMappers

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.kennelmanagercompose.core.toDisplayName
import com.example.kennelmanagercompose.domain.enums.*
import com.example.kennelmanagercompose.heattracking.domain.models.Heat
import com.example.kennelmanagercompose.pooptracking.domain.models.PoopScore
import com.example.kennelmanagercompose.pooptracking.ui.colormappers.toColor
import com.example.kennelmanagercompose.heattracking.ui.colormappers.toColor
// Note: Import your other .toColor() functions here for BodyScore, Severity, etc.

data class LegendEntry(val label: String, val color: Color)

object MapLensLegendMapper {
    /**
     * Retrieves all possible values for a given Lens to populate the UI legend.
     * Uses @Composable because your .toColor() extensions rely on your Compose Theme.
     */
    @Composable
    fun getLegend(lens: MapLens): List<LegendEntry> {
        return when (lens) {
            MapLens.FEEDING -> MissedMeals.entries.map {
                LegendEntry(it.name.toDisplayName(), it.toColor())
            }
            MapLens.POOP -> PoopScore.entries.map {
                LegendEntry(it.name.toDisplayName(), it.toColor())
            }
            MapLens.HEAT -> Heat.entries.map {
                LegendEntry(it.name.toDisplayName(), it.toColor())
            }
            MapLens.MEDICAL -> Severity.entries.map {
                LegendEntry(it.name.toDisplayName(), it.toColor())
            }
            MapLens.BODYSCORE -> BodyScore.entries.map {
                LegendEntry(it.name.toDisplayName(), it.toColor())
            }
            MapLens.READY_TO_RUN -> RunStatus.entries.map {
                LegendEntry(it.name.toDisplayName(), it.toColor())
            }
        }
    }
}