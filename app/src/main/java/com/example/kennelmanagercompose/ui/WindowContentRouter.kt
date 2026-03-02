package com.example.kennelmanagercompose.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.kennelmanagercompose.ui.state.WindowContent
import com.example.kennelmanagercompose.ui.components.KennelWindow
import com.example.kennelmanagercompose.ui.state.WindowState

@Composable
fun WindowContentRouter(
    window: WindowState,
    vm: WorkspaceViewModel
) {
    val density = LocalDensity.current.density

    // 1. Dynamic Title Selection
    val title = when (val c = window.content) {
        is WindowContent.DogProfile -> "Dog: ${c.dog.name}"
        is WindowContent.KennelOverview -> "Row: ${c.row}"
        is WindowContent.SystemAlert -> "⚠️ System"
        else -> "Kennel Manager"
    }

    // 2. The Master Window Wrapper
    // Added Modifier.zIndex(window.zIndex) so windows overlap correctly
    KennelWindow(
        state = window,
        title = title,
        modifier = Modifier.zIndex(window.zIndex),
        onMove = { screenDelta ->
            vm.moveWindow(
                windowId = window.id,
                delta = screenDelta,
                density = density
            )
        },
        onRelease = { vm.releaseWindow(window.id) }
    ) {
        // 3. Content Routing
        when (val content = window.content) {
            is WindowContent.KennelOverview -> {
                Text("Overview for ${content.row}", color = Color.White, modifier = Modifier.padding(16.dp))
            }
            is WindowContent.SystemAlert -> {
                Text(content.message, color = Color.Red, modifier = Modifier.padding(16.dp))
            }
            else -> {
                Text("Unknown View Type", color = Color.Gray, modifier = Modifier.padding(16.dp))
            }
        }
    }
}