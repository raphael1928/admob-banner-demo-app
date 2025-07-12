package br.com.raphael.admobbannerkitconsumer.model

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.call.*

class MovieRepository(
    private val client: HttpClient,
    private val apiKey: String
) {
    suspend fun getMovie(title: String): MovieResult? {
        // Extrair Base Url para arquivo de configs
        val response: MovieSearchResponse = client.get("https://api.themoviedb.org/3/search/movie") {
            parameter("api_key", apiKey)
            parameter("query", title)
            parameter("language", "pt-BR")
        }.body()

        return response.results.firstOrNull()
    }
}

