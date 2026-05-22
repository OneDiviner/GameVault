package com.example.impl.presentation.utils

import com.example.impl.domain.model.Platform
import gamevault.core.resource.generated.resources.Res
import gamevault.core.resource.generated.resources.android_icon
import gamevault.core.resource.generated.resources.apple_icon
import gamevault.core.resource.generated.resources.gamepad_icon
import gamevault.core.resource.generated.resources.nintendo_switch_icon
import gamevault.core.resource.generated.resources.play_station_icon
import gamevault.core.resource.generated.resources.windows_icon
import gamevault.core.resource.generated.resources.xbox_icon
import org.jetbrains.compose.resources.DrawableResource

internal fun Int.toIcon(): DrawableResource {
    return when(this) {
        1 -> Res.drawable.xbox_icon
        2 -> Res.drawable.play_station_icon
        3 -> Res.drawable.windows_icon
        4 -> Res.drawable.apple_icon
        5 -> Res.drawable.nintendo_switch_icon
        6 -> Res.drawable.android_icon
        else -> Res.drawable.gamepad_icon
    }
}