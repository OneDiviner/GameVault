package com.example.impl.data.mapper

import com.example.impl.data.model.GameDto
import com.example.impl.domain.model.Game

internal fun GameDto.toDomain() = Game(
    id = id,
    slug = slug,
    name = name,
)