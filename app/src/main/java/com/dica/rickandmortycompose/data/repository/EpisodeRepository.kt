package com.dica.rickandmortycompose.data.repository

import com.dica.rickandmortycompose.data.api.EpisodeApiService
import com.dica.rickandmortycompose.data.dto.Episodes.EpisodesDTO

class EpisodeRepository(
    private val apiService: EpisodeApiService
) {

    suspend fun fetchEpisodes(): List<EpisodesDTO>? {
        val response = apiService.fetchEpisodes()

        return if (response.isSuccessful) {
            response.body()?.results
        } else {
            emptyList()
        }
    }
    suspend fun fetchEpisodesById(id: Int): EpisodesDTO {
        return apiService.getEpisodeById(id)
    }
}