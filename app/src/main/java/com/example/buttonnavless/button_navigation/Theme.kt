package com.example.buttonnavless.button_navigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF9F0D0D), // Red for buttons (from Screen4)
    onPrimary = Color.White,
    background = Color(0xFFE0E0E0), // Current background
    onBackground = Color.Black,
    surface = Color(0xFFE0E0E0),
    onSurface = Color.Black,
    error = Color(0xFFB00020),
    onError = Color.White
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF9F0D0D), // Keep same red for buttons
    onPrimary = Color.White,
    background = Color(0xFF121212), // Dark background
    onBackground = Color.White,
    surface = Color(0xFF1E1E1E), // Slightly lighter for cards
    onSurface = Color.White,
    error = Color(0xFFCF6679),
    onError = Color.Black
)

@Composable
fun AppTheme(
    isDarkTheme: Boolean,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (isDarkTheme) DarkColorScheme else LightColorScheme,
        content = content
    )
}