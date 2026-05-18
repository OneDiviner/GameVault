package com.example.impl.domain.repository

import com.example.impl.domain.model.Game

interface HomeRepository {
    suspend fun getGames(): Result<List<Game>>
}