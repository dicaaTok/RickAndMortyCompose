package com.dica.rickandmortycompose.ui.screens.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dica.rickandmortycompose.data.dto.Characters.CharacterDTO
import com.dica.rickandmortycompose.data.repository.CharactersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CharacterViewModel(
    private val repository: CharactersRepository

) : ViewModel() {

    private val _characters = MutableStateFlow<List<CharacterDTO>>(emptyList())
    val characters = _characters.asStateFlow()


     fun fetchCharacters() {
         charactersRepository.fetchCharacters()?.let{
             _characters.value = it

         }
    }
}