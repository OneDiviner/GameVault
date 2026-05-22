package com.example.impl.data.mapper

import com.example.impl.data.model.ScreenshotsResponseDto
import com.example.impl.domain.model.GameScreenshots
import com.example.impl.domain.model.Screenshot

internal fun ScreenshotsResponseDto.toGameScreenshots() = GameScreenshots(
    count = count,
    screenshots = results.map { Screenshot(id = it.id, image = it.image) }
)