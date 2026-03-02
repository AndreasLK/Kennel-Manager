package com.example.kennelmanagercompose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kennelmanagercompose.domain.enums.MapLens
import com.example.kennelmanagercompose.ui.WindowContentRouter
import com.example.kennelmanagercompose.ui.WorkspaceViewModel

@Composable
fun KennelWorkspaceScreen(
    vm: WorkspaceViewModel = viewModel()
) {
    val windows by vm.windows.collectAsState()
    var selectedLens by remember { mutableStateOf(MapLens.READY_TO_RUN) }

    // 1. ROOT CONTAINER
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clipToBounds()
            .background(Color(0xFF121212)) // Deep dark background
    ) {
        // 2. THE WORLD LAYER
        // This Box handles the Panning and Zooming of the entire kennel map
        Box(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTransformGestures { _, pan, zoomChange, _ ->
                        vm.panOffset += pan
                        vm.zoom *= zoomChange
                    }
                }
                .graphicsLayer {
                    translationX = vm.panOffset.x
                    translationY = vm.panOffset.y
                    scaleX = vm.zoom
                    scaleY = vm.zoom
                }
        ) {
            // 3. THE WINDOWS LAYER
            // Iterates through all open windows and draws them in World Space
            windows.forEach { window ->
                WindowContentRouter(
                    window = window,
                    vm = vm
                )
            }
        }
    }
}