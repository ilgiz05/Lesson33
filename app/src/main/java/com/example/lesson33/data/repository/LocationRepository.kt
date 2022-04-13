package com.example.lesson33.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.lesson33.common.base.BaseRepository
import com.example.lesson33.data.remote.apiservices.LocationApi
import com.example.lesson33.data.remote.models.Location
import com.example.lesson33.data.remote.pagingsource.LocationPagingSource

class LocationRepository constructor(
    private val service: LocationApi
) : BaseRepository() {

    fun getLocations(): LiveData<PagingData<Location>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                prefetchDistance = 2
            ),
            pagingSourceFactory = {
                LocationPagingSource(service)
            }
        ).liveData
    }
}