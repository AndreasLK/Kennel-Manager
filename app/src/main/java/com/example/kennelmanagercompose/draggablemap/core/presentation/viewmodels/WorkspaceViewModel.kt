package com.example.kennelmanagercompose.draggablemap.core.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import androidx.lifecycle.ViewModel
import com.example.kennelmanagercompose.core.AppConfig
import com.example.kennelmanagercompose.dog.domain.models.Cage
import com.example.kennelmanagercompose.dog.domain.models.Dog
import com.example.kennelmanagercompose.draggablemap.core.presentation.models.WindowContent
import com.example.kennelmanagercompose.draggablemap.core.presentation.models.WindowState
import com.example.kennelmanagercompose.draggablemap.maplens.domain.enums.MapLens
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.math.abs

class WorkspaceViewModel : ViewModel() {
    private val _windows = MutableStateFlow<List<WindowState>>(emptyList())
    val windows = _windows.asStateFlow()

    private val _selectedLens = MutableStateFlow(MapLens.READY_TO_RUN)
    val selectedLens = _selectedLens.asStateFlow()

    var panOffset by mutableStateOf(Offset.Companion.Zero)
    var zoom by mutableStateOf(1f)
    private var currentMaxZ = 0f

    init {
        // Initial mock data can be loaded here or via loadKennelMap
    }

    fun setLens(lens: MapLens) {
        _selectedLens.value = lens
    }

    fun loadKennelMap(cages: List<Cage>, allDogs: List<Dog>) {
        _windows.value = cages.map { cage ->
            val dogsInCage = allDogs.filter { it.id in cage.dogsInside }
            WindowState(
                id = cage.id,
                position = Offset(cage.mapX, cage.mapY),
                content = WindowContent.KennelOverview(cage.rowName, dogsInCage),
                scaleX = cage.scaleX,
                scaleY = cage.scaleY
            )
        }
    }

    fun moveWindow(windowId: String, delta: Offset, density: Float) {
        _windows.value = _windows.value.map { window ->
            if (window.id == windowId) {
                val worldDeltaX = delta.x / density
                val worldDeltaY = delta.y / density

                val finalX = window.position.x + worldDeltaX
                val finalY = window.position.y + worldDeltaY


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
        val tw = target.dimensions.width.value
        val th = target.dimensions.height.value

        for (other in all.filter { it.id != targetId }) {
            val ox = other.position.x
            val oy = other.position.y
            val ow = other.dimensions.width.value
            val oh = other.dimensions.height.value

            if (abs(targetPos.x - (ox + ow)) < threshold) bX = ox + ow
            else if (abs((targetPos.x + tw) - ox) < threshold) bX = ox - tw
            else if (abs(targetPos.x - ox) < threshold) bX = ox
            else if (abs((targetPos.x + tw) - (ox + ow)) < threshold) bX = (ox + ow) - tw

            if (abs(targetPos.y - (oy + oh)) < threshold) bY = oy + oh
            else if (abs((targetPos.y + th) - oy) < threshold) bY = oy - th
            else if (abs(targetPos.y - oy) < threshold) bY = oy
            else if (abs((targetPos.y + th) - (oy + oh)) < threshold) bY = (oy + oh) - th
        }
        return Offset(bX, bY)
    }

    fun releaseWindow(id: String) {
        _windows.update { list ->
            list.map { if (it.id == id) it.copy(isCurrentlyActive = false) else it }
        }
    }
}