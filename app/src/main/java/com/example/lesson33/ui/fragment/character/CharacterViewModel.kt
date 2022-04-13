package com.example.lesson33.ui.fragment.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.lesson33.data.repository.CharacterRepository

class CharacterViewModel constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {

    fun getCharacters() = characterRepository.getCharacters().cachedIn(viewModelScope)

}