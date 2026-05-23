package com.example.designsystem

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.font.FontFamily
import com.example.designsystem.resources.GameVaultIcons
import com.example.designsystem.shapes.GameVaultShapes
import com.example.designsystem.spacings.GameVaultSpacings
import com.example.designsystem.theme.LocalGameVaultColors
import com.example.designsystem.theme.LocalGameVaultIcons
import com.example.designsystem.theme.LocalGameVaultShapes
import com.example.designsystem.theme.LocalGameVaultSpacings
import com.example.designsystem.theme.LocalGameVaultTypography
import com.example.designsystem.theme.colors.GameVaultColors
import com.example.designsystem.theme.colors.colors.darkGameVaultColors
import com.example.designsystem.theme.colors.colors.lightGameVaultColors
import com.example.designsystem.theme.colors.utils.toMaterialColorScheme
import com.example.designsystem.theme.typography.GameVaultTypography
import com.example.designsystem.theme.typography.utils.rememberTypography
import com.example.designsystem.theme.typography.utils.toMaterialTypography
import gamevault.core.designsystem.generated.resources.Res
import gamevault.core.designsystem.generated.resources.outfit_font
import org.jetbrains.compose.resources.Font

object GameVaultTheme {
    val colors: GameVaultColors
        @Composable
        @ReadOnlyComposable
        get() = LocalGameVaultColors.current

    val typography: GameVaultTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalGameVaultTypography.current

    val icons: GameVaultIcons
        @Composable
        @ReadOnlyComposable
        get() = LocalGameVaultIcons.current

    val shapes: GameVaultShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalGameVaultShapes.current

    val spacings: GameVaultSpacings
        @Composable
        @ReadOnlyComposable
        get() = LocalGameVaultSpacings.current
}

@Composable
fun GameVaultTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val targetColors = if (darkTheme) darkGameVaultColors else lightGameVaultColors
    val outfitFontFamily = FontFamily(Font(Res.font.outfit_font))

    val colors = remember { targetColors.copy() }.apply { updateColorsFrom(targetColors) }
    val typography = rememberTypography(outfitFontFamily)
    val icons = remember { GameVaultIcons() }
    val shapes = remember { GameVaultShapes() }
    val spacings = remember { GameVaultSpacings() }

    val materialColorScheme = colors.toMaterialColorScheme(isDark = darkTheme)
    val materialTypography = typography.toMaterialTypography()

    CompositionLocalProvider(
        LocalGameVaultColors provides colors,
        LocalGameVaultTypography provides typography,
        LocalGameVaultIcons provides icons,
        LocalGameVaultShapes provides shapes,
        LocalGameVaultSpacings provides spacings
    ) {
        MaterialTheme(
            colorScheme = materialColorScheme,
            typography = materialTypography,
            content = content
        )
    }
}