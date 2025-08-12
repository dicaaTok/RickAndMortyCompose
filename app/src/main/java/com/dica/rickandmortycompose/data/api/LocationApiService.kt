package com.dica.rickandmortycompose.data.api


import com.dica.rickandmortycompose.data.dto.Locations.LocationDTO
import com.dica.rickandmortycompose.data.dto.Locations.LocationResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface LocationApiService {

    @GET("location")
    suspend fun fetchLocations(): Response<LocationResponse>

    @GET("location/{id}")
    suspend fun getLocationById(@Path("id") id: Int): LocationDTO


}