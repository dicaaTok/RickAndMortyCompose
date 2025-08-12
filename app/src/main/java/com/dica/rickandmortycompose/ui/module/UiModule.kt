package com.dica.rickandmortycompose.ui.module

import com.dica.rickandmortycompose.ui.screens.characters.detailScreen.CharacterDetailViewModel
import com.dica.rickandmortycompose.ui.screens.characters.CharacterViewModel
import com.dica.rickandmortycompose.ui.screens.episods.EpisodeViewModel
import com.dica.rickandmortycompose.ui.screens.episods.detailScreen.EpisodeDetailingViewModel
import com.dica.rickandmortycompose.ui.screens.locations.LocationViewModel
import com.example.rickandmortycompose.ui.screens.locations.detailScreen.LocationDetailViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val uiModel = module{
    viewModelOf(::CharacterViewModel)
    viewModelOf(::LocationViewModel)
    viewModelOf(::EpisodeViewModel)
    viewModelOf(::CharacterDetailViewModel)
    viewModelOf(::LocationDetailViewModel)
    viewModelOf(::EpisodeDetailingViewModel)
}
