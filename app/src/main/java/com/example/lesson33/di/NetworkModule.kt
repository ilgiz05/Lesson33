package com.example.lesson33.di

import com.example.lesson33.data.remote.apiservices.CharacterApi
import com.example.lesson33.data.remote.apiservices.EpisodeApi
import com.example.lesson33.data.remote.apiservices.LocationApi
import com.example.lesson33.data.remote.retrofit.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    private val retrofit = RetrofitClient()

    @Provides
    @Singleton
    fun providesCharacterApi(): CharacterApi =
        retrofit.providesCharacterApi()

    @Provides
    @Singleton
    fun providesLocationApi(): LocationApi =
        retrofit.providesLocationApi()

    @Provides
    @Singleton
    fun providesEpisodesApi(): EpisodeApi =
        retrofit.providesEpisodesApi()

}