package com.example.impl.presentation.utils.mapper

import com.example.impl.domain.model.Game
import com.example.impl.presentation.model.GameItemState

internal fun Game.toGameItemState() = GameItemState(
    game = this,
    images = listOf(this.backgroundImage),
    isLoading = true
)