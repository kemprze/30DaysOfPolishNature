package com.kemprze.a30daysofpolishnature.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font

import com.kemprze.a30daysofpolishnature.R
// Set of Material typography styles to start with
/**
 * Define Font Families using custom TTF files.
 * The font files (notoserif_regular.ttf, notoserif_bold.ttf, cabin_regular.ttf)
 * must be placed in the 'res/font' directory of your Android module.
 */

// Noto Serif Font Family (used for body text, emphasizing readability)
private val NotoSerifFontFamily = FontFamily(
    Font(R.font.notoserif_regular, FontWeight.Normal),
    Font(R.font.notoserif_bold, FontWeight.Bold)
)

// Cabin Font Family (used for display and title text, for a more distinct look)
private val CabinFontFamily = FontFamily(
    Font(R.font.cabin_regular, FontWeight.Normal)
    // Note: If you have a Bold Cabin file, add it here (e.g., R.font.cabin_bold, FontWeight.Bold)
)

/**
 * Default Compose Typography (Material 3).
 * This uses the custom fonts defined above.
 * Cabin is used for Display and Headline/Title styles.
 * Noto Serif is used for Body and Label styles.
 */
val AppTypography = Typography(
    // --- Display Styles (Large, attention-grabbing text) ---
    displayLarge = TextStyle(
        fontFamily = CabinFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp
    ),
    displayMedium = TextStyle(
        fontFamily = CabinFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 45.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.sp
    ),

    // --- Headline Styles (For primary section titles) ---
    headlineLarge = TextStyle(
        fontFamily = CabinFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = CabinFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp
    ),

    // --- Title Styles (For component titles, like dialogs or card headers) ---
    titleLarge = TextStyle(
        fontFamily = CabinFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    titleMedium = TextStyle(
        fontFamily = CabinFontFamily,
        fontWeight = FontWeight.Bold, // Using bold Noto Serif for emphasis in titles
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),

    // --- Body Styles (The main text of your application) ---
    bodyLarge = TextStyle(
        fontFamily = NotoSerifFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = NotoSerifFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),
    bodySmall = TextStyle(
        fontFamily = NotoSerifFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp
    ),

    // --- Label Styles (For buttons, captions, and small helper text) ---
    labelLarge = TextStyle(
        fontFamily = NotoSerifFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    labelMedium = TextStyle(
        fontFamily = NotoSerifFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)