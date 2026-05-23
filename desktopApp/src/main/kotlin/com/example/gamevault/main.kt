package com.example.gamevault

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.gamevault.di.initKoin
import org.koin.core.logger.Level

fun main() = application {

    initKoin {
        printLogger(Level.INFO)
    }

    Window(
        onCloseRequest = ::exitApplication,
        title = "GameVault",
    ) {
        GameVaultApp()
    }
}