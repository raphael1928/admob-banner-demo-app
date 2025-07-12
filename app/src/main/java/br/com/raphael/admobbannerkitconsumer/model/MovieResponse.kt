package br.com.raphael.admobbannerkitconsumer.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieSearchResponse(
    val results: List<MovieResult>
)

@Serializable
data class MovieResult(
    val id: Int,
    @SerialName("title") val title: String,
    @SerialName("overview") val overview: String,
    @SerialName("poster_path") val posterPath: String? = null
)

