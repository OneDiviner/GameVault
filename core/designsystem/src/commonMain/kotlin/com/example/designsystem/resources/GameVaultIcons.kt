package com.example.designsystem.resources

import androidx.compose.runtime.Immutable
import gamevault.core.designsystem.generated.resources.Res
import gamevault.core.designsystem.generated.resources.android_icon
import gamevault.core.designsystem.generated.resources.apple_icon
import gamevault.core.designsystem.generated.resources.gamepad_icon
import gamevault.core.designsystem.generated.resources.logo_icon
import gamevault.core.designsystem.generated.resources.nintendo_switch_icon
import gamevault.core.designsystem.generated.resources.play_station_icon
import gamevault.core.designsystem.generated.resources.search_icon
import gamevault.core.designsystem.generated.resources.windows_icon
import gamevault.core.designsystem.generated.resources.xbox_icon
import org.jetbrains.compose.resources.DrawableResource

@Immutable
class GameVaultIcons internal constructor(
    val android: DrawableResource = Res.drawable.android_icon,
    val apple: DrawableResource = Res.drawable.apple_icon,
    val gamepad: DrawableResource = Res.drawable.gamepad_icon,
    val logo: DrawableResource = Res.drawable.logo_icon,
    val nintendoSwitch: DrawableResource = Res.drawable.nintendo_switch_icon,
    val playStation: DrawableResource = Res.drawable.play_station_icon,
    val search: DrawableResource = Res.drawable.search_icon,
    val windows: DrawableResource = Res.drawable.windows_icon,
    val xbox: DrawableResource = Res.drawable.xbox_icon,
)