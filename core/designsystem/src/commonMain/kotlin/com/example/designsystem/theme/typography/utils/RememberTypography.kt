package com.example.designsystem.theme.typography.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.font.FontFamily
import com.example.designsystem.theme.typography.GameVaultTypography

@Composable
internal fun rememberTypography(fontFamily: FontFamily): GameVaultTypography {
    return remember(fontFamily) {
        GameVaultTypography(fontFamily = fontFamily)
    }
}