package com.example.lesson33.serviclacator

import com.example.lesson33.data.remote.retrofit.RetrofitClient
import com.example.lesson33.data.repository.CharacterRepository
import com.example.lesson33.data.repository.EpisodeRepository
import com.example.lesson33.data.repository.LocationRepository
import com.example.lesson33.ui.fragment.character.CharacterViewModel
import com.example.lesson33.ui.fragment.episodes.EpisodeViewModel
import com.example.lesson33.ui.fragment.location.LocationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val remoteModule = module {
    single { RetrofitClient() }
    single { get<RetrofitClient>().providesEpisodesApi() }
    single { get<RetrofitClient>().providesLocationApi() }
    single { get<RetrofitClient>().providesCharacterApi() }
}
val viewModelModule = module {
    viewModel { EpisodeViewModel(get()) }
    viewModel { LocationViewModel(get()) }
    viewModel { CharacterViewModel(get()) }
}
val repositoriesModel = module {
    factory { LocationRepository(get()) }
    factory { EpisodeRepository(get()) }
    factory { CharacterRepository(get()) }
}

