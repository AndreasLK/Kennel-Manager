package com.example.kennelmanagercompose.draggablemap.core.domain.models

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.DpSize
import com.example.kennelmanagercompose.core.AppConfig
import com.example.kennelmanagercompose.draggablemap.core.domain.interfaces.WindowContent
import java.util.UUID

data class WindowState(
    val id: String = UUID.randomUUID().toString(),
    val position: Offset,
    val content: WindowContent,

    val scaleX: Float = 1f,
    val scaleY: Float = 1f,

    val zIndex: Float = 0f,
    val isCurrentlyActive: Boolean = false,

    val dimensions: DpSize = DpSize(
        width =  AppConfig.DEFAULT_WINDOW_WIDTH  * scaleX,
        height = AppConfig.DEFAULT_WINDOW_HEIGHT * scaleY
    )
)