package com.mz_dev.tallerecommerce.ui.theme

import androidx.compose.ui.graphics.Color

val PrimaryColor = HexToColor.getColor("#ed4960")
val BackgroundDarkColor = HexToColor.getColor("#19203c")
val BlackThemeColor = HexToColor.getColor("#222a32")
val SurfaceBlackThemeColor = HexToColor.getColor("#1c2639")

object HexToColor {
    fun getColor(color: String): Color {
        return Color(android.graphics.Color.parseColor(color))
    }
}