package com.example.impl.domain.usecase

import com.example.impl.domain.model.Game
import com.example.impl.domain.repository.HomeRepository

internal class GetGamesUseCase(
    private val repository: HomeRepository
) {
    suspend operator fun invoke(): Result<List<Game>> {
        return repository.getGames()
    }
}