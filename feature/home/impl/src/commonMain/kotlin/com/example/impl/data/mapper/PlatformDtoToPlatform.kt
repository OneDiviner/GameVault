package com.example.impl.data.mapper

import com.example.impl.data.model.PlatformDto
import com.example.impl.domain.model.Platform
import com.example.impl.domain.model.PlatformGroup

internal fun PlatformDto.toDomain() = Platform(
    id = id,
    name = name
)

internal fun Int.toPlatformGroup(): PlatformGroup { // TODO: inline?
    return when(this) {
        1, 14, 80, 186 -> PlatformGroup.XBOX
        16, 18, 187 -> PlatformGroup.PLAYSTATION
        4, 6, 171 -> PlatformGroup.PC
        3,5, 19 -> PlatformGroup.APPLE
        7 -> PlatformGroup.NINTENDO
        21 -> PlatformGroup.ANDROID
        else -> PlatformGroup.UNKNOWN
    }
}