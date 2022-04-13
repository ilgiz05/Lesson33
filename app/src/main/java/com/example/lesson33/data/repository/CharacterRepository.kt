package com.example.lesson33.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.lesson33.common.base.BaseRepository
import com.example.lesson33.data.remote.apiservices.CharacterApi
import com.example.lesson33.data.remote.models.Character
import com.example.lesson33.data.remote.pagingsource.CharacterPagingSource

class CharacterRepository(
    private val service: CharacterApi
) : BaseRepository() {


    fun getCharacter(page: Int) = doRequest {
        service.getCharacter(page)
    }

    fun getCharacters(): LiveData<PagingData<Character>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                prefetchDistance = 2
            ),
            pagingSourceFactory = {
                CharacterPagingSource(service)
            }
        ).liveData
    }
}