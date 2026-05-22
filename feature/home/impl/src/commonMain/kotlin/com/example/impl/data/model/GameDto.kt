package com.example.impl.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class GameDto(
    @SerialName("id") val id: Int,
    @SerialName("slug") val slug: String,
    @SerialName("name") val name: String,
    @SerialName("background_image") val backgroundImage: String,
    @SerialName("metacritic") val metacritic: Int?,
    @SerialName("platforms") val platforms: List<PlatformsDto>?,
)