package com.example.gamevault

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import theme.GameVaultTheme

fun main() = application {
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