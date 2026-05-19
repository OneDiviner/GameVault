package com.example.impl.presentation

import androidx.lifecycle.ViewModel
import com.example.impl.domain.usecase.GetGamesUseCase
import com.example.impl.presentation.contract.HomeSideEffect
import com.example.impl.presentation.contract.HomeState
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

internal class HomeViewModel(
    private val getGamesUseCase: GetGamesUseCase
): ViewModel(), ContainerHost<HomeState, HomeSideEffect> {

    override val container = container<HomeState, HomeSideEffect>(HomeState())

    init {
        loadGames()
    }

    private fun loadGames() = intent {
        reduce { state.copy(isLoading = true, error = null) }

        getGamesUseCase()
            .onSuccess { games ->
                reduce {
                    state.copy(isLoading = false, games = games)
                }
            }
            .onFailure { error ->
                reduce { state.copy(isLoading = false, games = emptyList()) }
                postSideEffect(HomeSideEffect.ShowError(error.message ?: "Unknown error"))
            }
    }
}