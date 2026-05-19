package com.example.impl.data.model

import kotlinx.serialization.Serializable

@Serializable
internal data class GameDto(
    val id: Int,
    val slug: String,
    val name: String
)

@Serializable
internal data class GamesResponseDto(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<GameDto>
)