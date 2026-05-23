package com.example.designsystem.theme

import androidx.compose.runtime.staticCompositionLocalOf
import com.example.designsystem.resources.GameVaultIcons
import com.example.designsystem.shapes.GameVaultShapes
import com.example.designsystem.spacings.GameVaultSpacings
import com.example.designsystem.theme.colors.GameVaultColors
import com.example.designsystem.theme.typography.GameVaultTypography

internal val LocalGameVaultColors = staticCompositionLocalOf<GameVaultColors> {
    error("GameVaultColors not initialized!")
}

internal val LocalGameVaultTypography = staticCompositionLocalOf<GameVaultTypography> {
    error("GameVaultTypography not initialized!")
}

internal val LocalGameVaultIcons = staticCompositionLocalOf<GameVaultIcons> {
    error("GameVaultIcons not initialized!")
}

internal val LocalGameVaultShapes = staticCompositionLocalOf<GameVaultShapes> {
    error("GameVaultShapes not initialized!")
}

internal val LocalGameVaultSpacings = staticCompositionLocalOf<GameVaultSpacings> {
    error("GameVaultSpacings not initialized!")
}