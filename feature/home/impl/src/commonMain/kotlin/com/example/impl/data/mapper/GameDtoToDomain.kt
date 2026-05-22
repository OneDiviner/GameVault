package com.example.impl.data.mapper

import com.example.impl.data.model.GameDto
import com.example.impl.domain.model.Game

internal fun GameDto.toDomain() = Game(
    id = id,
    name = name,
    backgroundImage = backgroundImage,
    metacritic = metacritic.toString(),
    platformsGroup = platforms
        ?.map { it.platform.id.toPlatformGroup() }
        ?.distinct() ?: emptyList()
)