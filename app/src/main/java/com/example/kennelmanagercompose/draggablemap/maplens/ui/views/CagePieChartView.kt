package com.example.kennelmanagercompose.draggablemap.maplens.ui.views

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.draw.clipToBounds
import kotlin.math.sqrt

@Composable
fun CagePieChartView(
    dogColors: List<Color>,
    modifier: Modifier = Modifier
) {
    if (dogColors.isEmpty()) {
        Box(modifier = modifier.fillMaxSize())
        return
    }

    Canvas(modifier = modifier.fillMaxSize().clipToBounds()) {
        val count = dogColors.size
        val sweepAngle = 360f / count

        val centerX = size.width / 2f
        val centerY = size.height / 2f
        val radius = sqrt(centerX * centerX + centerY * centerY)

        val circleSize = radius * 2f
        val topLeftX = centerX - radius
        val topLeftY = centerY - radius

        // Define the bounding rectangle for the native canvas drawArc
        val rect = Rect(
            left = topLeftX,
            top = topLeftY,
            right = topLeftX + circleSize,
            bottom = topLeftY + circleSize
        )

        drawIntoCanvas { canvas ->
            // Create a native paint object with anti-aliasing explicitly turned off
            val paint = Paint().apply {
                isAntiAlias = false
            }

            dogColors.forEachIndexed { index, color ->
                // Update the paint color for the current dog
                paint.color = color

                // Draw the raw arc directly to the canvas
                canvas.drawArc(
                    rect = rect,
                    startAngle = (index * sweepAngle) - 90f,
                    sweepAngle = sweepAngle,
                    useCenter = true,
                    paint = paint
                )
            }
        }
    }
}