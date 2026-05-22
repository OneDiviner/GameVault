package com.example.impl.domain.model

internal class Game(
    val id: Int,
    val name: String,
    val backgroundImage: String,
    val metacritic: String,
    val platformsGroup: List<PlatformGroup>
    //val platforms: List<Platform>,
)