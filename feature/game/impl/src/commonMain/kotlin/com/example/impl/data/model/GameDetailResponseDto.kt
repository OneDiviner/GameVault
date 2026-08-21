package com.example.impl.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
internal data class GameDetailResponseDto(
    @SerialName("id") val id: Int,
    @SerialName("slug") val slug: String,
    @SerialName("name") val name: String,
    @SerialName("name_original") val nameOriginal: String,
    @SerialName("description") val description: String,
    @SerialName("metacritic") val metacritic: Int?,
    @SerialName("metacritic_platforms") val metacriticPlatforms: List<GamePlatformMetacriticDto>?,
    @SerialName("released") val released: String?,
    @SerialName("tba") val tba: Boolean,
    @SerialName("updated") val updated: String,
    @SerialName("background_image") val backgroundImage: String?,
    @SerialName("background_image_additional") val backgroundImageAdditional: String?,
    @SerialName("website") val website: String?,
    @SerialName("rating") val rating: Double,
    @SerialName("rating_top") val ratingTop: Int,
    @SerialName("ratings") val ratings: JsonObject?, //TODO: Find Object
    @SerialName("reactions") val reactions: JsonObject?,//TODO: Find Object
    @SerialName("added") val added: Int,
    @SerialName("added_by_status") val addedByStatus: JsonObject?,//TODO: Find Object
    @SerialName("playtime") val playtime: Int,
    @SerialName("screenshots_count") val screenshotsCount: Int,
    @SerialName("movies_count") val moviesCount: Int,
    @SerialName("creators_count") val creatorsCount: Int,
    @SerialName("achievements_count") val achievementsCount: Int,
    @SerialName("parent_achievements_count") val parentAchievementsCount: String,
    @SerialName("reddit_url") val redditUrl: String?,
    @SerialName("reddit_name") val redditName: String?,
    @SerialName("reddit_description") val redditDescription: String?,
    @SerialName("reddit_logo") val redditLogo: String?,
    @SerialName("reddit_count") val redditCount: Int,
    @SerialName("twitch_count") val twitchCount: String,
    @SerialName("youtube_count") val youtubeCount: String,
    @SerialName("reviews_text_count") val reviewsTextCount: String,
    @SerialName("ratings_count") val ratingsCount: Int,
    @SerialName("suggestions_count") val suggestionsCount: Int,
    @SerialName("alternative_names") val alternativeNames: List<String>?,
    @SerialName("metacritic_url") val metacriticUrl: String?,
    @SerialName("parents_count") val parentsCount: Int,
    @SerialName("additions_count") val additionsCount: Int,
    @SerialName("game_series_count") val gameSeriesCount: Int,
    @SerialName("esrb_rating") val esrbRating: EsrbRatingDto?,
    //@SerialName("platforms") val platforms: List<PlatformsDto>?
)

@Serializable
internal data class EsrbRatingDto(
    @SerialName("id") val id: Int,
    @SerialName("slug") val slug: String,
    @SerialName("name") val name: String
)

@Serializable
internal data class GamePlatformMetacriticDto(
    @SerialName("metascore") val metascore: Int,
    @SerialName("url") val url: Int,
) {

}