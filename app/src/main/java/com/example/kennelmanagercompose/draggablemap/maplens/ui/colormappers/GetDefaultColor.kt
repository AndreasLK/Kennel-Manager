package com.example.kennelmanagercompose.draggablemap.maplens.ui.colormappers

import androidx.compose.ui.graphics.Color
import com.example.kennelmanagercompose.draggablemap.maplens.domain.enums.DefaultType
import com.example.kennelmanagercompose.draggablemap.core.presentation.themes.KennelTheme
import com.example.kennelmanagercompose.draggablemap.maplens.ui.themes.DefaultTheme

fun DefaultType.toColor(theme: DefaultTheme = KennelTheme.default) : Color = when (this){
        DefaultType.WORST -> theme.worst
        DefaultType.BAD -> theme.bad
        DefaultType.OKAY -> theme.okay
        DefaultType.GOOD -> theme.good
        DefaultType.Best -> theme.best
}