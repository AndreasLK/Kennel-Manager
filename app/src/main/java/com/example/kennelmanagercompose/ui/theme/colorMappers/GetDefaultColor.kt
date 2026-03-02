package com.example.kennelmanagercompose.ui.theme.colorMappers

import androidx.compose.ui.graphics.Color
import com.example.kennelmanagercompose.domain.enums.DefaultType
import com.example.kennelmanagercompose.ui.theme.KennelTheme
import com.example.kennelmanagercompose.ui.theme.sub.DefaultTheme

fun DefaultType.toColor(theme: DefaultTheme = KennelTheme.default) : Color = when (this){
        DefaultType.WORST -> theme.worst
        DefaultType.BAD -> theme.bad
        DefaultType.OKAY -> theme.okay
        DefaultType.GOOD -> theme.good
        DefaultType.Best -> theme.best
}