package com.example.impl.presentation.contract

import com.example.impl.domain.model.Game
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

internal data class HomeState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val games: ImmutableList<Game> = persistentListOf(),
)