package com.example.lesson33.data.remote.retrofit

import com.example.lesson33.data.remote.apiservices.CharacterApi
import com.example.lesson33.data.remote.apiservices.EpisodeApi
import com.example.lesson33.data.remote.apiservices.LocationApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val provideClient: OkHttpClient = OkHttpClient()
        .newBuilder()
        .connectTimeout(20, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)
        .addInterceptor(provideLoginInterceptor())
        .build()

    private fun provideLoginInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    private val provideRetrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(provideClient)
        .build()


    fun providesCharacterApi(): CharacterApi =
        provideRetrofit.create(CharacterApi::class.java)

    fun providesLocationApi(): LocationApi =
        provideRetrofit.create(LocationApi::class.java)

    fun providesEpisodesApi(): EpisodeApi =
        provideRetrofit.create(EpisodeApi::class.java)


}