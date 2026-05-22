package com.example.gamevault

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.api.HomeRoute
import com.example.impl.presentation.HomeFeature

@Composable
fun GameVaultApp() {
    MaterialTheme {
        //val backStack = rememberNavBackStack(HomeRoute)

        Scaffold(
          modifier = Modifier
              .fillMaxSize()
              .background(color = MaterialTheme.colorScheme.background)
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