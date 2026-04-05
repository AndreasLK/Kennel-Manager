package com.example.kennelmanagercompose.draggablemap.maplens.ui.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kennelmanagercompose.draggablemap.core.ui.themes.KennelTheme


@Preview(showBackground = true, backgroundColor = 0xFF121212, widthDp = 800, heightDp =1200)
@Composable
fun KennelPalettePreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        PaletteRow(
            title = "Default",
            colors = listOf(
                "Worst" to KennelTheme.default.worst,
                "Bad" to KennelTheme.default.bad,
                "Okay" to KennelTheme.default.okay,
                "Good" to KennelTheme.default.good,
                "Best" to KennelTheme.default.best
            )
        )

        PaletteRow(
            title = "Ready To Run",
            colors = listOf(
                "Cant" to KennelTheme.runStatus.cantRun,
                "Shouldnt" to KennelTheme.runStatus.shouldntRun,
                "Can" to KennelTheme.runStatus.canRun,
                "Should" to KennelTheme.runStatus.shouldRun,
                "Needs" to KennelTheme.runStatus.needsToRun
            )
        )


        PaletteRow(
            title = "Did Eat (Feeding)",
            colors = listOf(
                "Did Eat" to KennelTheme.missedMeals.didEat,
                "Missed 1" to KennelTheme.missedMeals.missed1,
                "Missed 2" to KennelTheme.missedMeals.missed2,
                "Missed 3" to KennelTheme.missedMeals.missed3,
                "Missed 4" to KennelTheme.missedMeals.missed4,
                "Critical" to KennelTheme.missedMeals.critical
            )
        )

        PaletteRow(
            title = "Poop Score",
            colors = listOf(
                "Hard" to KennelTheme.poop.hard,
                "Firm" to KennelTheme.poop.firm,
                "Log" to KennelTheme.poop.log,
                "Soggy" to KennelTheme.poop.soggy,
                "Moist" to KennelTheme.poop.moist,
                "thin" to KennelTheme.poop.thin,
                "watery" to KennelTheme.poop.watery
            )
        )

        PaletteRow(
            title = "BodyScore",
            colors = listOf(
                "Very Thin" to KennelTheme.bodyScore.veryThin,
                "Thin" to KennelTheme.bodyScore.thin,
                "Ideal" to KennelTheme.bodyScore.ideal,
                "Thick" to KennelTheme.bodyScore.thick,
                "Obese" to KennelTheme.bodyScore.obese,
                "Unknown" to KennelTheme.bodyScore.unknown
            )
        )

        PaletteRow(
            title = "Heat",
            colors = listOf(
                "Not In Heat" to KennelTheme.heat.notInHeat,
                "Calculated Heat" to KennelTheme.heat.calculatedHeat,
                "Coming In Heat" to KennelTheme.heat.comingInHeat,
                "Standing Heat" to KennelTheme.heat.standingHeat,
                "Going Out of Heat" to KennelTheme.heat.goingOutOfHeat
            )
        )


    }
}

@Composable
fun PaletteRow(title: String, colors: List<Pair<String, Color>>) {
    Column {
        Text(text = title, color = Color.White, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            colors.forEach { (name, color) ->
                ColorSwatch(name, color)
            }
        }
    }
}

@Composable
fun ColorSwatch(name: String, color: Color) {
    // Determines if text should be black or white based on background darkness
    val textColor = if (color.luminance() > 0.5f) Color.Black else Color.White

    Box(
        modifier = Modifier
            .size(width = 100.dp, height = 80.dp)
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Text(text = name, color = textColor)
    }
}