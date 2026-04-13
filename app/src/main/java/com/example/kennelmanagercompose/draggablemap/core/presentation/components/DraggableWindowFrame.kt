package com.example.kennelmanagercompose.draggablemap.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.example.kennelmanagercompose.draggablemap.core.presentation.models.WindowState

/**
 * The physical "shell" of every window in the Kennel Manager.
 * Handles movement, boundaries, and visual elevation.
 */
@Composable
fun DraggableWindowFrame(
    windowState: WindowState,
    title: String,
    onMove: (Offset) -> Unit,
    onRelease: () -> Unit,
    modifier: Modifier = Modifier, // ADDED: To receive zIndex and other external modifiers
    onClose: () -> Unit = {},
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier // CHAINED: Passes the external modifier (like zIndex) through
            .offset (
                x = windowState.position.x.dp,
                y = windowState.position.y.dp
            )
            .size(windowState.dimensions)
            .graphicsLayer {
                // Visual feedback: Window grows slightly and drops a larger shadow when active
                val scale = if (windowState.isCurrentlyActive) 1.02f else 1f
                scaleX = scale
                scaleY = scale
                shadowElevation = if (windowState.isCurrentlyActive) 30f else 8f
                shape = RoundedCornerShape(8.dp)
                clip = true
            }
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFF2D2D2D))
            .border(
                width = 1.dp,
                color = if (windowState.isCurrentlyActive) Color.White.copy(0.4f) else Color.Gray.copy(0.2f),
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        // --- TITLE BAR (The Draggable Handle) ---
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp)
                .background(if (windowState.isCurrentlyActive) Color(0xFF555555) else Color(0xFF444444))
                .pointerInput(Unit) {
                    // We only want the window to move when the user drags the HEADER
                    detectDragGestures(
                        onDrag = { change, amount ->
                            change.consume()
                            onMove(amount)
                        },
                        onDragEnd = onRelease
                    )
                }
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title,
                color = Color.White,
                style = MaterialTheme.typography.labelSmall
            )

            // Close Button placeholder (Can be implemented later)
            // Box(Modifier.size(16.dp).background(Color.Red.copy(0.5f)).clickable { onClose() })
        }

        // --- WINDOW CONTENT AREA ---
        Box(modifier = Modifier.fillMaxSize()) {
            content()
        }
    }
}