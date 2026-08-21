package com.example.gamevault

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.designsystem.Colors
import com.example.designsystem.GameVaultTheme
import com.example.impl.presentation.home.HomeFeature

@Composable
fun GameVaultApp() {

    GameVaultTheme {
        //val backStack = rememberNavBackStack(HomeRoute)

        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Colors.background)
        ) { paddingValues ->
            /*NavDisplay(
                backStack = backStack,
                entryProvider = entryProvider {
                    entry<HomeRoute> {
                        HomeFeature()
                    }
                }
            )*/
            HomeFeature(paddingValues)

        }
    }
}