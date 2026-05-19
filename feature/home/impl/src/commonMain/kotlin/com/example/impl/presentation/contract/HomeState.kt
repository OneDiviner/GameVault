package com.example.impl.presentation.contract

import com.example.impl.domain.model.Game

internal data class HomeState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val games: List<Game> = emptyList()
)