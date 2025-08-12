package com.dica.rickandmortycompose.ui.screens.episods

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dica.rickandmortycompose.data.dto.Episodes.EpisodesDTO
import com.example.rickandmortycompose.data.repository.EpisodeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EpisodeViewModel(
    private val episodeRepository: EpisodeRepository

): ViewModel() {
    private val _episodesStateFlow = MutableStateFlow<List<EpisodesDTO>>(emptyList())
    val episodesStateFlow = _episodesStateFlow.asStateFlow()

    fun fetchEpisodes() {
        viewModelScope.launch(Dispatchers.IO) {
            episodeRepository.fetchEpisodes()?.let {
                _episodesStateFlow.value = it
            }
        }
    }

}