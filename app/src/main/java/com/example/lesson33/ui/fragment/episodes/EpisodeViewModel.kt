package com.example.lesson33.ui.fragment.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.lesson33.data.repository.EpisodeRepository

class EpisodeViewModel constructor(
    private val episodeRepository: EpisodeRepository
) : ViewModel() {

    fun getEpisodes() = episodeRepository.getEpisodes().cachedIn(viewModelScope)

}