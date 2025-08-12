package com.dica.rickandmortycompose.data.repository

import com.dica.rickandmortycompose.data.api.LocationApiService
import com.dica.rickandmortycompose.data.dto.Locations.LocationDTO

class LocationRepository(
    private val apiService: LocationApiService
) {

    suspend fun fetchLocations(): List<LocationDTO>? {
        val response = apiService.fetchLocations()

        return if (response.isSuccessful) {
            response.body()?.results
        } else {
            emptyList()
        }
    }
    suspend fun fetchLocationById(id: Int): LocationDTO {
        return apiService.getLocationById(id)
    }

}
