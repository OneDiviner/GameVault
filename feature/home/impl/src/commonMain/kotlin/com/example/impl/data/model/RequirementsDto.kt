package com.example.impl.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class RequirementsDto(
    @SerialName("minimum") val minimum: String,
    @SerialName("recommended") val recommended: String,
)