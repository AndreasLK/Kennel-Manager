package com.example.kennelmanagercompose.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.kennelmanagercompose.domain.interfaces.KennelStateProvider
import com.example.kennelmanagercompose.ui.state.WindowContent
import com.example.kennelmanagercompose.ui.components.KennelWindow
import com.example.kennelmanagercompose.ui.state.WindowState
import com.example.kennelmanagercompose.maplens.ui.theme.MapLensColorMapper
import com.example.kennelmanagercompose.maplens.ui.views.CagePieChartView

@Composable
fun WindowContentRouter(
    window: WindowState,
    vm: WorkspaceViewModel,
    provider: KennelStateProvider
) {
    val density = LocalDensity.current.density
    val selectedLens by vm.selectedLens.collectAsState()

    KennelWindow(
        state = window,
        title = when (val c = window.content) {
            is WindowContent.KennelOverview -> "Row: ${c.row}"
            else -> "Kennel Manager"
        },
        modifier = Modifier.zIndex(window.zIndex),
        onMove = { vm.moveWindow(window.id, it, density) },
        onRelease = { vm.releaseWindow(window.id) }
    ) {
        when (val content = window.content) {
            is WindowContent.KennelOverview -> {
                val dogColors = content.dogs.map { dog ->
                    MapLensColorMapper.mapColor(selectedLens, dog, provider)
                }
                CagePieChartView(dogColors = dogColors)
            }
            else -> Text("Generic Content", color = Color.White, modifier = Modifier.padding(16.dp))
        }
    }
}