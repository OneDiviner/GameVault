package com.example.impl.domain.model

internal data class Platform(
    val id: Int,
    val name: String,
)

internal enum class PlatformGroup(
    val id: Int,
    val displayName: String
) {
    UNKNOWN(
        id = 0,
        displayName = "Unknown"
    ),
    XBOX(
        id = 1,
        displayName = "Xbox"
    ),
    PLAYSTATION(
        id = 2,
        displayName = "Play Station"
    ),
    PC(
        id = 3,
        displayName = "PC"
    ),
    APPLE(
        id = 4,
        displayName = "PC"
    ),
    NINTENDO(
        id = 5,
        displayName = "Nintendo"
    ),
    ANDROID(
        id = 6,
        displayName = "Android"
    )
}