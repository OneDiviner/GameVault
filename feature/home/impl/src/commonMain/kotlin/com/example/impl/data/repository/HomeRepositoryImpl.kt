package com.example.impl.data.repository

import com.example.impl.data.HomeRemoteDataSource
import com.example.impl.data.mapper.toDomain
import com.example.impl.data.mapper.toGameScreenshots
import com.example.impl.domain.model.Game
import com.example.impl.domain.model.GameScreenshots
import com.example.impl.domain.repository.HomeRepository
import com.mayakapps.kache.InMemoryKache
import com.mayakapps.kache.KacheStrategy

internal class HomeRepositoryImpl(
    private val homeRemoteDataSource: HomeRemoteDataSource
) : HomeRepository {

    private val screenshotsCache = InMemoryKache<Int, GameScreenshots>(2097152) {
        strategy = KacheStrategy.LRU
    }

    override suspend fun getGames(
        page: Int?,
        pageSize: Int,
        searchQuery: String?
    ): Result<List<Game>> {
        return homeRemoteDataSource.getGames(
            page = page,
            pageSize = pageSize,
            searchQuery = searchQuery
        ).map { dto ->
            dto.results.map { it.toDomain() }
        }
    }

    override suspend fun getGameScreenshots(
        gameId: String,
        ordering: String?,
        page: Int?,
        pageSize: Int?
    ): Result<GameScreenshots> {

        val cache = screenshotsCache.get(gameId.toInt()) //DANGER: Do not safe
        if (cache != null) return Result.success(cache)

        return homeRemoteDataSource.getGameScreenshots(
            gameId = gameId,
            ordering = ordering,
            page = page,
            pageSize = pageSize
        ).map { dto ->
            val screenshots = dto.toGameScreenshots()
            screenshotsCache.put(gameId.toInt(), screenshots)
            screenshots
        }.onFailure { exception ->
            println("ERROR: Failed to fetch screenshots for game $gameId: ${exception.message}")
        }/*.getOrDefault(emptyList())*/ //TODO: Think about it
    }
}