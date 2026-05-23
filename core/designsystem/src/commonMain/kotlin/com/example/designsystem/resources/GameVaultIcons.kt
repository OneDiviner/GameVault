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
    android: DrawableResource = Res.drawable.android_icon,
    apple: DrawableResource = Res.drawable.apple_icon,
    gamepad: DrawableResource = Res.drawable.gamepad_icon,
    logo: DrawableResource = Res.drawable.logo_icon,
    nintendoSwitch: DrawableResource = Res.drawable.nintendo_switch_icon,
    playStation: DrawableResource = Res.drawable.play_station_icon,
    search: DrawableResource = Res.drawable.search_icon,
    windows: DrawableResource = Res.drawable.windows_icon,
    xbox: DrawableResource = Res.drawable.xbox_icon,
)