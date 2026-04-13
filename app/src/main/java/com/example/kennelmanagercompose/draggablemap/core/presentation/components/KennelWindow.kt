package com.example.kennelmanagercompose.draggablemap.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kennelmanagercompose.draggablemap.core.presentation.models.WindowContent
import com.example.kennelmanagercompose.draggablemap.core.presentation.models.WindowState

@Composable
fun KennelWindow(
    state: WindowState,
    title: String,
    onMove: (Offset) -> Unit,
    onRelease: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    DraggableWindowFrame(
        windowState = state,
        title = title,
        onMove = onMove,
        onRelease = onRelease,
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF1E1E1E))
                .border(1.dp, Color.White.copy(alpha = 0.1f))
        ) {
            content()
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF121212)
@Composable
fun KennelWindowPreview() {
    MaterialTheme {
        KennelWindow(
            state = WindowState(position = Offset.Zero, content = WindowContent.SystemAlert("Test")),
            title = "Preview Shell",
            onMove = {}, onRelease = {}
        ) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Inside the Master Template", color = Color.White)
            }
        }
    }
}