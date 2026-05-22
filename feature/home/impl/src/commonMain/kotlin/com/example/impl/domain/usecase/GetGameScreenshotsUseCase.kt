package com.example.impl.domain.usecase

import com.example.impl.domain.model.GameScreenshots
import com.example.impl.domain.repository.HomeRepository

internal class GetGameScreenshotsUseCase(
    private val homeRepository: HomeRepository
) {
    suspend operator fun invoke(
        gameId: String,
        ordering: String?,
        page: Int?,
        pageSize: Int?
    ): Result<GameScreenshots> {
        return homeRepository.getGameScreenshots(
            gameId = gameId,
            ordering = ordering,
            page = page,
            pageSize = pageSize
        )
    }
}