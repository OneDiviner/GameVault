package com.example.impl.presentation.home

import androidx.lifecycle.ViewModel
import com.example.impl.domain.usecase.GetGameScreenshotsUseCase
import com.example.impl.domain.usecase.GetGamesUseCase
import com.example.impl.presentation.contract.HomeIntent
import com.example.impl.presentation.contract.HomeSideEffect
import com.example.impl.presentation.contract.HomeState
import com.example.impl.presentation.utils.mapper.toGameItemState
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

internal class HomeViewModel(
    private val getGamesUseCase: GetGamesUseCase,
    private val getGameScreenshotsUseCase: GetGameScreenshotsUseCase
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

    fun loadGameItemImages(id: Int) = intent {

        //TODO: Check if images already exist

        reduce {
            state.copy(
                games = state.games.map {
                    if (it.game.id == id) it.copy(isLoading = true) else it
                }.toImmutableList()
            )
        }

        getGameScreenshotsUseCase(
            gameId = id.toString(),
            ordering = null,
            page = 1,
            pageSize = 7
        ).onSuccess { response ->
            reduce {
                state.copy(
                    games = state.games.map { gameState ->
                        if (gameState.game.id == id)
                            gameState.copy(
                                isLoading = false,
                                images = listOf(gameState.game.backgroundImage) + response.screenshots.map { it.image } //TODO: use buildList
                            )
                        else
                            gameState
                    }.toImmutableList()
                )
            }
        }.onFailure {
            //TODO
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
                state.copy(
                    isLoading = false,
                    games = games.map {
                        it.toGameItemState()
                    }.toImmutableList()
                )
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
                state.copy(
                    isLoading = false,
                    games = games.map {
                        it.toGameItemState()
                    }.toImmutableList(),
                    error = null
                )
            }
        }.onFailure { error ->
            reduce { state.copy(isLoading = false, games = persistentListOf()) }
            postSideEffect(HomeSideEffect.ShowError(error.message ?: "Unknown error"))
        }
    }
}