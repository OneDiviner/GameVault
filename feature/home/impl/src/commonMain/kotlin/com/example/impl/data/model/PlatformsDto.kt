package com.example.impl.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class PlatformsDto(
    @SerialName("platform") val platform: PlatformDto,
    /*@SerialName("released_at") val releasedAt: String?,
    @SerialName("requirements") val requirements: RequirementsDto?,*/ //TODO: Is this needed now?
)