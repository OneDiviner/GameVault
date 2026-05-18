package com.example.impl.data

import com.example.impl.data.model.GamesResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

internal class HomeRemoteDataSource(
    private val ktorClient: HttpClient
) {
    suspend fun getGames(): Result<GamesResponseDto> = runCatching {
        ktorClient.get("games").body()
    }
}