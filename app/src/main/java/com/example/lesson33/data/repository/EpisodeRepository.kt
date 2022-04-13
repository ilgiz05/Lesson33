package com.example.lesson33.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.lesson33.common.base.BaseRepository
import com.example.lesson33.data.remote.apiservices.EpisodeApi
import com.example.lesson33.data.remote.models.Episodes
import com.example.lesson33.data.remote.pagingsource.EpisodePagingSource

class EpisodeRepository constructor(
    private val service: EpisodeApi
) : BaseRepository() {

    fun getEpisodes(): LiveData<PagingData<Episodes>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                prefetchDistance = 2
            ),
            pagingSourceFactory = {
                EpisodePagingSource(service)
            }
        ).liveData
    }

}