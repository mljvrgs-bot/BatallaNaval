package com.example.navalprotocol.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Paleta naval: fondo azul muy oscuro, acento ambar (guino a las fichas/comodines).
val Navy900 = Color(0xFF07111F)
val Navy800 = Color(0xFF0E1C30)
val Navy700 = Color(0xFF16294A)
val Sea = Color(0xFF1D4E89)
val Amber = Color(0xFFFFB703)
val Hit = Color(0xFFE63946)
val Miss = Color(0xFF8D99AE)
val Ship = Color(0xFF4CC9F0)
val TextHigh = Color(0xFFEAF0F7)
val TextLow = Color(0xFF8DA2BC)

private val NavalColors = darkColorScheme(
    primary = Amber, onPrimary = Navy900,
    secondary = Ship, onSecondary = Navy900,
    background = Navy900, onBackground = TextHigh,
    surface = Navy800, onSurface = TextHigh,
    surfaceVariant = Navy700, onSurfaceVariant = TextLow,
    outline = Sea, error = Hit
)

@Composable
fun NavalTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = NavalColors, content = content)
}