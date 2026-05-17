package com.example.gamevault

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import gamevault.core.resource.generated.resources.Res
import gamevault.core.resource.generated.resources.android_icon
import org.jetbrains.compose.resources.painterResource

@Composable
fun GameVaultApp() {
    MaterialTheme {
        Scaffold(
          modifier = Modifier
              .fillMaxSize()
              .background(color = MaterialTheme.colorScheme.background)
        ) { paddingValues ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddingValues)
            ) {
                Icon(
                    modifier = Modifier,
                    painter = painterResource(Res.drawable.android_icon),
                    contentDescription = null
                )
                Text(
                    modifier = Modifier,
                    text = "Hello, KMP! :)",
                    style = MaterialTheme.typography.headlineLarge
                )
            }
        }
    }
}