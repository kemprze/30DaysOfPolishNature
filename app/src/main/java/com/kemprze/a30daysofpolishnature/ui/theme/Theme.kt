package com.kemprze.a30daysofpolishnature.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

/**
 * Custom Material 3 Theme for the application.
 *
 * This theme brings together:
 * 1. Your custom Typography (Type.kt)
 * 2. Your custom Green/Rose Color Palette (Color.kt)
 */
@Composable
fun _30DaysOfPolishNatureTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // We default dynamicColor to 'false' so your custom Green theme is used by default.
    // If set to 'true', Android 12+ devices would use the user's wallpaper colors instead.
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    // Optional: This block colors the system Status Bar to match your app's theme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            // Set status bar color to the primary color of the scheme
            window.statusBarColor = colorScheme.primary.toArgb()
            // If the background is light, we want dark icons on the status bar, and vice versa
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography, // Integrates your NotoSerif & Cabin setup
        content = content
    )
}