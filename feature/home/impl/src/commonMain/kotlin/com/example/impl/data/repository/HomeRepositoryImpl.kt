package com.example.impl.data.repository

import com.example.impl.data.HomeRemoteDataSource
import com.example.impl.data.mapper.toDomain
import com.example.impl.data.model.GameDto
import com.example.impl.domain.model.Game
import com.example.impl.domain.repository.HomeRepository

internal class HomeRepositoryImpl(
    private val homeRemoteDataSource: HomeRemoteDataSource
) : HomeRepository {
    override suspend fun getGames(): Result<List<Game>> {
        return homeRemoteDataSource.getGames().map { dto ->
            dto.results.map { it.toDomain() }
        }
    }
}

// TODO: Create UseCase, correct data process with run catching,
// example:
/*
remoteDataSource.getGames()
.onSuccess { dto -> */
/* данные пришли *//*
 }
.onFailure { error -> */
/* обработка ошибки *//*
 }
.map { it.results } // трансформация если success
.getOrDefault(emptyList()) // значение по умолчанию если failure*/
