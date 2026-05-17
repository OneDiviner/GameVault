package theme

import androidx.compose.runtime.Composable

@Composable
expect fun GameVaultTheme(
    isDarkTheme: Boolean,
    isDynamicColors: Boolean,
    content: @Composable () -> Unit
)