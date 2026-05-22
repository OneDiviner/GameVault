package com.example.impl.data

import com.example.impl.data.model.GamesResponseDto
import com.example.impl.data.model.ScreenshotsResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.parameters

internal class HomeRemoteDataSource(
    private val ktorClient: HttpClient
) {
    suspend fun getGames(
        page: Int?,
        pageSize: Int,
        searchQuery: String?
    ): Result<GamesResponseDto> = runCatching {
        ktorClient.get("games") {
            parameter("page", page)
            parameter("page_size", pageSize)
            parameter("search", searchQuery)
        }.body()
    }

    suspend fun getGameScreenshots(
        gameId: String,
        ordering: String?,
        page: Int?,
        pageSize: Int?
    ): Result<ScreenshotsResponseDto> = runCatching {
        ktorClient.get("games/$gameId/screenshots") {
            parameter("ordering", ordering)
            parameter("page", page)
            parameter("page_size", pageSize)
        }.body()
    }
}