package com.example.kennelmanagercompose.ui

import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Offset
import androidx.lifecycle.ViewModel
import com.example.kennelmanagercompose.ui.state.WindowContent
import com.example.kennelmanagercompose.core.AppConfig
import com.example.kennelmanagercompose.domain.models.housing.Cage
import com.example.kennelmanagercompose.ui.state.WindowState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.math.abs

class WorkspaceViewModel : ViewModel() {
    private val _windows = MutableStateFlow<List<WindowState>>(emptyList())
    val windows = _windows.asStateFlow()

    var panOffset by mutableStateOf(Offset.Zero)
    var zoom by mutableStateOf(1f)
    private var currentMaxZ = 0f

    init {
        _windows.value = listOf(
            WindowState(
                id = "1",
                position = Offset(100f, 100f),
                content = WindowContent.KennelOverview("A1")
            ),
            WindowState(
                id = "2",
                position = Offset(500f, 200f),
                content = WindowContent.KennelOverview("B4"),
                scaleX = 2f
            )
        )
    }


    fun loadKennelMap(cages: List<Cage>){
        _windows.value = cages.map { cage ->
            WindowState(
                id = cage.id,
                position = Offset(cage.mapX, cage.mapY),
                content = WindowContent.KennelOverview(cage.rowName),

                scaleX = cage.scaleX,
                scaleY = cage.scaleY
            )
        }
    }

    fun moveWindow(
        windowId: String,
        delta: Offset,
        density: Float
    ) {
        _windows.value = _windows.value.map { window ->
            if (window.id == windowId) {
                val worldDeltaX = delta.x / density
                val worldDeltaY = delta.y / density

                val finalX = window.position.x + worldDeltaX
                val finalY = window.position.y + worldDeltaY

                // Snapping
                val finalPos = calculateSmartSnap(
                    targetId = windowId,
                    targetPos = Offset(finalX, finalY),
                    all = _windows.value,
                    density = density
                )

                window.copy(
                    position = finalPos,
                    zIndex = (currentMaxZ + 0.1f).also { currentMaxZ = it },
                    isCurrentlyActive = true
                )
            } else window
        }
    }

    private fun calculateSmartSnap(
        targetId: String,
        targetPos: Offset,
        all: List<WindowState>,
        density: Float
    ): Offset {
        val threshold = AppConfig.SNAP_THRESHOLD * density
        var bX = targetPos.x
        var bY = targetPos.y

        val target = all.find { it.id == targetId } ?: return targetPos
        // IMPORTANT: Get dimensions in DP units
        val tw = target.dimensions.width.value
        val th = target.dimensions.height.value

        for (other in all.filter { it.id != targetId }) {
            val ox = other.position.x
            val oy = other.position.y
            val ow = other.dimensions.width.value
            val oh = other.dimensions.height.value

            // --- HORIZONTAL SNAPPING (X-Axis) ---
            if (abs(targetPos.x - (ox + ow)) < threshold) bX = ox + ow                      // Left edge to Other's Right
            else if (abs((targetPos.x + tw) - ox) < threshold) bX = ox - tw                 // Right edge to Other's Left
            else if (abs(targetPos.x - ox) < threshold) bX = ox                             // Align Left edges
            else if (abs((targetPos.x + tw) - (ox + ow)) < threshold) bX = (ox + ow) - tw   //Align Right Edges

            // --- VERTICAL SNAPPING (Y-Axis) ---
            // This is likely where the "Sideways only" bug lived
            if (abs(targetPos.y - (oy + oh)) < threshold) bY = oy + oh                      // Top edge to Other's Bottom
            else if (abs((targetPos.y + th) - oy) < threshold) bY = oy - th                 // Bottom edge to Other's Top
            else if (abs(targetPos.y - oy) < threshold) bY = oy                             // Align Top edges
            else if (abs((targetPos.y + th) - (oy + oh)) < threshold) bY = (oy + oh) - th   // Align Bottom Edges
        }
        return Offset(bX, bY)
    }

    fun releaseWindow(id: String) {
        _windows.update { list ->
            list.map { if (it.id == id) it.copy(isCurrentlyActive = false) else it }
        }
    }
}