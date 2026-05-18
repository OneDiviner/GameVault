package com.example.gamevault

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.gamevault.di.initKoin
import org.koin.core.logger.Level
import theme.GameVaultTheme

fun main() = application {

    initKoin {
        printLogger(Level.INFO)
    }

    Window(
        onCloseRequest = ::exitApplication,
        title = "GameVault",
    ) {
        GameVaultTheme(
            isDarkTheme = isSystemInDarkTheme(),
            isDynamicColors = false
        ) {
            GameVaultApp()
        }
    }
}