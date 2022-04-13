package com.example.lesson33.data.remote.pagingsource

import com.example.lesson33.common.base.BasePagingSource
import com.example.lesson33.data.remote.apiservices.LocationApi
import com.example.lesson33.data.remote.models.Location

class LocationPagingSource(
    private val serviceLocationApi: LocationApi
) : BasePagingSource<Location, Any?>({ position ->
    serviceLocationApi.getLocation(position)
})