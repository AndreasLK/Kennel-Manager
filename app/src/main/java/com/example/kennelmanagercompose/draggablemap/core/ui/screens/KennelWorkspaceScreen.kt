package com.example.kennelmanagercompose.draggablemap.core.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
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
import com.example.kennelmanagercompose.draggablemap.core.domain.interfaces.KennelStateProvider
import com.example.kennelmanagercompose.draggablemap.maplens.ui.components.MapLensMenu
import com.example.kennelmanagercompose.draggablemap.core.ui.routers.WindowContentRouter
import com.example.kennelmanagercompose.draggablemap.core.domain.models.WorkspaceViewModel

@Composable
fun KennelWorkspaceScreen(
    vm: WorkspaceViewModel = viewModel(),
    provider: KennelStateProvider
) {
    val windows by vm.windows.collectAsState()
    val selectedLens by vm.selectedLens.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clipToBounds()
            .background(Color(0xFF121212))
            .systemBarsPadding()) {

        // Combine Picker and Legend Menu
        MapLensMenu(
            currentLens = selectedLens,
            onLensSelected = { vm.setLens(it) },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
                .zIndex(100f)
        )

        // The World Layer
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
            windows.forEach { window ->
                WindowContentRouter(
                    window = window,
                    vm = vm,
                    provider = provider
                )
            }
        }
    }
}