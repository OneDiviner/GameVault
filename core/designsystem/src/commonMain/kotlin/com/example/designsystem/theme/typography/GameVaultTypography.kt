package com.example.designsystem.theme.typography

import androidx.compose.material3.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Immutable
class GameVaultTypography internal constructor(
    fontFamily: FontFamily
) {
    val displayLarge = TextStyle(
        fontFamily = fontFamily,
        fontSize = 42.sp,
        letterSpacing = 0.sp,
        fontWeight = FontWeight.SemiBold
    )
    val displayMedium = TextStyle(
        fontFamily = fontFamily,
        fontSize = 35.sp,
        letterSpacing = 0.sp,
        fontWeight = FontWeight.SemiBold
    )
    val displaySmall = TextStyle(
        fontFamily = fontFamily,
        fontSize = 29.sp,
        letterSpacing = 0.sp,
        fontWeight = FontWeight.SemiBold
    )

    val titleLarge = TextStyle(
        fontFamily = fontFamily,
        fontSize = 24.sp,
        letterSpacing = 0.sp,
        fontWeight = FontWeight.SemiBold
    )
    val titleMedium = TextStyle(
        fontFamily = fontFamily,
        fontSize = 20.sp,
        letterSpacing = 0.sp,
        fontWeight = FontWeight.SemiBold
    )
    val titleSmall = TextStyle(
        fontFamily = fontFamily,
        fontSize = 17.sp,
        letterSpacing = 0.sp,
        fontWeight = FontWeight.SemiBold
    )

    val headlineLarge = TextStyle(
        fontFamily = fontFamily,
        fontSize = 14.sp,
        letterSpacing = 0.sp,
        fontWeight = FontWeight.SemiBold
    )
    val headlineMedium = TextStyle(
        fontFamily = fontFamily,
        fontSize = 12.sp,
        letterSpacing = 0.sp,
        fontWeight = FontWeight.SemiBold
    )
    val headlineSmall = TextStyle(
        fontFamily = fontFamily,
        fontSize = 10.sp,
        letterSpacing = 0.sp,
        fontWeight = FontWeight.SemiBold
    )

    val bodyLarge = TextStyle(
        fontFamily = fontFamily,
        fontSize = 14.sp,
        letterSpacing = 0.sp,
        fontWeight = FontWeight.Light
    )
    val bodyMedium = TextStyle(
        fontFamily = fontFamily,
        fontSize = 12.sp,
        letterSpacing = 0.sp,
        fontWeight = FontWeight.Light
    )
    val bodySmall = TextStyle(
        fontFamily = fontFamily,
        fontSize = 10.sp,
        letterSpacing = 0.sp,
        fontWeight = FontWeight.Light
    )

    val labelLarge = TextStyle(
        fontFamily = fontFamily,
        fontSize = 14.sp,
        letterSpacing = 0.sp,
        fontWeight = FontWeight.Light
    )
    val labelMedium = TextStyle(
        fontFamily = fontFamily,
        fontSize = 12.sp,
        letterSpacing = 0.sp,
        fontWeight = FontWeight.Light
    )
    val labelSmall = TextStyle(
        fontFamily = fontFamily,
        fontSize = 10.sp,
        letterSpacing = 0.sp,
        fontWeight = FontWeight.Light
    )
}