package com.example.kennelmanagercompose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kennelmanagercompose.domain.interfaces.KennelStateProvider
import com.example.kennelmanagercompose.ui.WindowContentRouter
import com.example.kennelmanagercompose.ui.WorkspaceViewModel
import com.example.kennelmanagercompose.ui.components.LensPickerRow

@Composable
fun KennelWorkspaceScreen(
    vm: WorkspaceViewModel = viewModel(),
    provider: KennelStateProvider // Added provider
) {
    val windows by vm.windows.collectAsState()
    val selectedLens by vm.selectedLens.collectAsState()

    Box(modifier = Modifier.fillMaxSize().clipToBounds().background(Color(0xFF121212))) {
        LensPickerRow(
            currentLens = selectedLens,
            onLensSelected = { vm.setLens(it) },
            modifier = Modifier.align(Alignment.TopCenter).zIndex(100f).padding(top = 16.dp)
        )

        Box(
            modifier = Modifier.fillMaxSize()
                .pointerInput(Unit) {
                    detectTransformGestures { _, pan, zoomChange, _ ->
                        vm.panOffset += pan
                        vm.zoom *= zoomChange
                    }
                }
                .graphicsLayer {
                    translationX = vm.panOffset.x; translationY = vm.panOffset.y
                    scaleX = vm.zoom; scaleY = vm.zoom
                }
        ) {
            windows.forEach { window ->
                WindowContentRouter(window = window, vm = vm, provider = provider)
            }
        }
    }
}