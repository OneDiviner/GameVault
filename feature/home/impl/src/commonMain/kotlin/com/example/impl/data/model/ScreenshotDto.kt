package com.example.impl.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ScreenshotDto(
    @SerialName("id") val id: Int,
    @SerialName("image") val image: String,
    //@SerialName("hidden") val isHidden: Boolean,
    @SerialName("width") val width: Int,
    @SerialName("height") val height: Int,
)