package com.example.impl.presentation

import androidx.lifecycle.ViewModel
import com.example.impl.domain.usecase.GetGamesUseCase
import com.example.impl.presentation.contract.HomeIntent
import com.example.impl.presentation.contract.HomeSideEffect
import com.example.impl.presentation.contract.HomeState
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

internal class HomeViewModel(
    private val getGamesUseCase: GetGamesUseCase
): ViewModel(), ContainerHost<HomeState, HomeSideEffect> {

    override val container = container<HomeState, HomeSideEffect>(HomeState())

    init {
        loadGames()
    }

    fun dispatch(intent: HomeIntent) {
        when(intent) {
            is HomeIntent.SearchGames -> searchGames(intent.searchQueryValue)
        }
    }

    private fun loadGames() = intent {
        reduce { state.copy(isLoading = true, error = null) }
        getGamesUseCase(
            page = 1,
            pageSize = 16,
            searchQuery = null
        ).onSuccess { games ->
            reduce {
                state.copy(isLoading = false, games = games.toImmutableList())
            }
        }
        .onFailure { error ->
            reduce { state.copy(isLoading = false, games = persistentListOf()) }
            postSideEffect(HomeSideEffect.ShowError(error.message ?: "Unknown error"))
        }
    }

    private fun searchGames(searchQueryValue: String) = intent {
        reduce { state.copy(isLoading = true, error = null) }
        getGamesUseCase(
            page = 1,
            pageSize = 16,
            searchQuery = searchQueryValue
        ).onSuccess { games ->
            reduce {

                val newData = games.toList().toImmutableList()

                state.copy(isLoading = false, games = newData, error = null)
            }
        }.onFailure { error ->
            reduce { state.copy(isLoading = false, games = persistentListOf()) }
            postSideEffect(HomeSideEffect.ShowError(error.message ?: "Unknown error"))
        }
    }
}