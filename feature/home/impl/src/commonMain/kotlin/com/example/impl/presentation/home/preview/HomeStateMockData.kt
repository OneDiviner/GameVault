package com.example.impl.presentation.home.preview

import com.example.impl.domain.model.Game
import com.example.impl.domain.model.PlatformGroup
import com.example.impl.presentation.model.GameItemState
import kotlinx.collections.immutable.persistentListOf

internal object GameMockData {
    val gameItemsList = persistentListOf(
        GameItemState(
            game = Game(
                id = 1,
                name = "The Witcher 3: Wild Hunt",
                backgroundImage = "https://api.rawg.io/media/games/618/618c2031a07bbff69450c7144ea46115.jpg",
                metacritic = "92",
                platformsGroup = listOf(PlatformGroup.PC, PlatformGroup.PLAYSTATION, PlatformGroup.XBOX)
            )
        ),
        GameItemState(
            game = Game(
                id = 2,
                name = "Cyberpunk 2077",
                backgroundImage = "https://api.rawg.io/media/games/26d/26d443e1e5defa9fb693b95df1344ade.jpg",
                metacritic = "86",
                platformsGroup = listOf(PlatformGroup.PC, PlatformGroup.PLAYSTATION, PlatformGroup.XBOX)
            )
        ),
        GameItemState(
            game = Game(
                id = 3,
                name = "Grand Theft Auto V",
                backgroundImage = "https://api.rawg.io/media/games/456/456fc5ab11a1f1247e63f33271a41b57.jpg",
                metacritic = "97",
                platformsGroup = listOf(PlatformGroup.PC, PlatformGroup.PLAYSTATION, PlatformGroup.XBOX)
            )
        ),
        GameItemState(
            game = Game(
                id = 4,
                name = "Red Dead Redemption 2",
                backgroundImage = "https://api.rawg.io/media/games/511/511ab6f1979f5721738510ad4fed570a.jpg",
                metacritic = "97",
                platformsGroup = listOf(PlatformGroup.PLAYSTATION, PlatformGroup.XBOX)
            )
        ),
        GameItemState(
            game = Game(
                id = 5,
                name = "The Legend of Zelda: Breath of the Wild",
                backgroundImage = "https://api.rawg.io/media/games/cc1/cc12b580e3b8aa0e8aa3575aa59ea4bc.jpg",
                metacritic = "97",
                platformsGroup = listOf(PlatformGroup.NINTENDO)
            )
        ),
        GameItemState(
            game = Game(
                id = 6,
                name = "Elden Ring",
                backgroundImage = "https://api.rawg.io/media/games/5ec/5ec12307c40eb6adac2c4a652da7efef.jpg",
                metacritic = "96",
                platformsGroup = listOf(PlatformGroup.PC, PlatformGroup.PLAYSTATION, PlatformGroup.XBOX)
            )
        ),
        GameItemState(
            game = Game(
                id = 7,
                name = "Hades",
                backgroundImage = "https://api.rawg.io/media/games/1f4/1f43a558c0ebf913be1d1cb4011e4f4d.jpg",
                metacritic = "93",
                platformsGroup = listOf(PlatformGroup.PC, PlatformGroup.PLAYSTATION, PlatformGroup.XBOX, PlatformGroup.NINTENDO, PlatformGroup.APPLE)
            )
        ),
        GameItemState(
            game = Game(
                id = 8,
                name = "God of War (2018)",
                backgroundImage = "https://api.rawg.io/media/games/4be/4be6a4ad9296da31804bda9177cf6c94.jpg",
                metacritic = "94",
                platformsGroup = listOf(PlatformGroup.PC, PlatformGroup.PLAYSTATION)
            )
        ),
        GameItemState(
            game = Game(
                id = 9,
                name = "DOOM Eternal",
                backgroundImage = "https://api.rawg.io/media/games/3ea/3ea3c9bbd940b6cb7f2139e42d3d4e89.jpg",
                metacritic = "88",
                platformsGroup = listOf(PlatformGroup.PC, PlatformGroup.PLAYSTATION, PlatformGroup.XBOX, PlatformGroup.NINTENDO)
            )
        ),
        GameItemState(
            game = Game(
                id = 10,
                name = "Genshin Impact",
                backgroundImage = "https://api.rawg.io/media/games/d11/d11ca730d99bc2d5a62402241c7b0496.jpg",
                metacritic = "81",
                platformsGroup = listOf(PlatformGroup.PC, PlatformGroup.PLAYSTATION, PlatformGroup.ANDROID, PlatformGroup.APPLE)
            )
        )
    )
}