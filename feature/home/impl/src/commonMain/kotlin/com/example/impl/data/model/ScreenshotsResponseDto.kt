package com.example.impl.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ScreenshotsResponseDto(
    @SerialName("count") val count: Int,
    @SerialName("next") val next: Int?,
    @SerialName("previous") val previous: Int?,
    @SerialName("results") val results: List<ScreenshotDto>,
)