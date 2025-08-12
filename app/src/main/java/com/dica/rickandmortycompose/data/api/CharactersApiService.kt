package com.dica.rickandmortycompose.data.api


import com.dica.rickandmortycompose.data.dto.Characters.CharacterDTO
import com.dica.rickandmortycompose.data.dto.Characters.CharactersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CharactersApiService {

    @GET("character")
    suspend fun fetchCharacters(): Response<CharactersResponse>


    @GET("character/{id}")
    suspend fun fetchCharacterById(@Path("id") id: Int): Response<CharacterDTO>

}