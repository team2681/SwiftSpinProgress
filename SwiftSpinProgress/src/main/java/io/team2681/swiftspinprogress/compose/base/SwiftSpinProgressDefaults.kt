package io.team2681.swiftspinprogress.compose.base

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


object SwiftSpinProgressDefaults {
    val Size = 40.dp
    val StaticItemColor = Color(0xff757575)
    val DynamicItemColor = Color(0xffEEEEEE)
}

enum class SwiftSpinShape {
    Rect,
    RoundedRect
}