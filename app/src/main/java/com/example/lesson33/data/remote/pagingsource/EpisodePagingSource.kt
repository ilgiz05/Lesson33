package com.example.lesson33.data.remote.pagingsource

import com.example.lesson33.common.base.BasePagingSource
import com.example.lesson33.data.remote.apiservices.EpisodeApi
import com.example.lesson33.data.remote.models.Episodes

class EpisodePagingSource(
    private val servicesEpisodeApi: EpisodeApi
) : BasePagingSource<Episodes, Any?>({ position ->
    servicesEpisodeApi.getEpisode(position)
})