package com.example.lesson33.data.remote.pagingsource

import com.example.lesson33.common.base.BasePagingSource
import com.example.lesson33.data.remote.apiservices.CharacterApi
import com.example.lesson33.data.remote.models.Character

class CharacterPagingSource(
    private val serviceCharacterApi: CharacterApi
) : BasePagingSource<Character, Any?>({ position ->
    serviceCharacterApi.getCharacter(position)
})
