package com.dica.rickandmortycompose.data.repository

import com.dica.rickandmortycompose.data.api.CharactersApiService
import com.dica.rickandmortycompose.data.dto.Characters.CharacterDTO

class CharactersRepository(
    private val apiService: CharactersApiService
) {
    suspend fun fetchCharacters(): List<CharacterDTO>? {
        val response = apiService.fetchCharacters()
        return if (response.isSuccessful) response.body()?.results else null
    }

    suspend fun fetchCharacterById(id: Int): CharacterDTO? {
        val response = apiService.fetchCharacterById(id)
        return if (response.isSuccessful) response.body() else null
    }
}
