package com.example.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.font.FontFamily
import com.example.designsystem.resources.GameVaultIcons
import com.example.designsystem.shapes.GameVaultShapes
import com.example.designsystem.spacings.GameVaultSpacings
import com.example.designsystem.theme.colors.GameVaultColors
import com.example.designsystem.theme.colors.colors.darkGameVaultColors
import com.example.designsystem.theme.typography.GameVaultTypography
import org.jetbrains.compose.resources.Font

internal val LocalGameVaultColors = compositionLocalOf<GameVaultColors> {
    darkGameVaultColors
}

internal val LocalGameVaultTypography = compositionLocalOf<GameVaultTypography> {
    GameVaultTypography()
}

internal val LocalGameVaultIcons = staticCompositionLocalOf<GameVaultIcons> {
    GameVaultIcons()
}

internal val LocalGameVaultShapes = staticCompositionLocalOf<GameVaultShapes> {
    GameVaultShapes()
}

internal val LocalGameVaultSpacings = staticCompositionLocalOf<GameVaultSpacings> {
    GameVaultSpacings()
}