package com.example.impl.domain.repository

import com.example.impl.domain.model.Game
import com.example.impl.domain.model.GameScreenshots

internal interface HomeRepository {
    suspend fun getGames(
        page: Int?,
        pageSize: Int,
        searchQuery: String?
    ): Result<List<Game>>

    suspend fun getGameScreenshots(
        gameId: String,
        ordering: String?,
        page: Int?,
        pageSize: Int?
    ): Result<GameScreenshots>
}