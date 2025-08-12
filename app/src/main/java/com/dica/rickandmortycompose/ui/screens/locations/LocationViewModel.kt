package com.dica.rickandmortycompose.ui.screens.locations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dica.rickandmortycompose.data.dto.Locations.LocationDTO
import com.dica.rickandmortycompose.data.repository.LocationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LocationViewModel(
    private val locationRepository: LocationRepository

): ViewModel() {
    private val _locationsStateFlow = MutableStateFlow<List<LocationDTO>>(emptyList())
    val locationsStateFlow = _locationsStateFlow.asStateFlow()

    fun fetchLocations() {
        viewModelScope.launch(Dispatchers.IO) {
            locationRepository.fetchLocations()?.let {
                _locationsStateFlow.value = it
            }
        }
    }
}