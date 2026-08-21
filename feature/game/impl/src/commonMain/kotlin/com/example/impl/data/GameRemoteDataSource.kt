package com.example.impl.data

import com.example.impl.data.model.GameDetailResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

internal class GameRemoteDataSource(
    private val ktorClient: HttpClient
) {
    suspend fun getGameDetail(id: String): Result<GameDetailResponseDto> = runCatching {
        ktorClient.get("games/$id").body()
    }
}