package com.example.kennelmanagercompose.ui.views

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun CagePieChartView(
    dogColors: List<Color>, // Pre-resolved colors based on the current mode
    modifier: Modifier = Modifier
) {

    if (dogColors.isEmpty()) { //draw nothing if there are no colors
        Box(modifier = modifier.fillMaxSize())
        return
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize(0.8f)) {
            val count = dogColors.size.coerceAtLeast(1)
            val sweepAngle = 360f / count

            dogColors.forEachIndexed { index, color ->
                drawArc(
                    color = color,
                    startAngle = index * sweepAngle,
                    sweepAngle = sweepAngle,
                    useCenter = true
                )
            }
        }
    }
}