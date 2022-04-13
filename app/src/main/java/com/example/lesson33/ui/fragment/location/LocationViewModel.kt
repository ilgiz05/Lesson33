package com.example.lesson33.ui.fragment.location

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.lesson33.data.repository.LocationRepository

class LocationViewModel constructor(
    private val locationRepository: LocationRepository
) : ViewModel() {

    fun getLocations() = locationRepository.getLocations().cachedIn(viewModelScope)

}