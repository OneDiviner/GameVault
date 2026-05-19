package com.example.impl.domain.repository

import com.example.impl.domain.model.Game

internal interface HomeRepository {
    suspend fun getGames(): Result<List<Game>>
}