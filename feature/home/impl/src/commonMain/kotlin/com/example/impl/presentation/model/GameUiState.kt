package com.example.impl.presentation.model

import com.example.impl.domain.model.Game

internal data class GameItemState(
    val game: Game,
    val images: List<String> = listOf(game.backgroundImage),
    val isLoading: Boolean = false
)
