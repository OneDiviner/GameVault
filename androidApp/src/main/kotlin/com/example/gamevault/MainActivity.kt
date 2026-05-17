package com.example.gamevault

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import theme.GameVaultTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            GameVaultTheme(
                isDarkTheme = isSystemInDarkTheme(),
                isDynamicColors = false
            ) {
                GameVaultApp()
            }
        }
    }
}