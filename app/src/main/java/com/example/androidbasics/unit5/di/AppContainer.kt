package com.example.androidbasics.unit5.di

import com.example.androidbasics.unit5.data.MarsPhotosRepository
import com.example.androidbasics.unit5.data.NetworkMarsPhotosRepository
import com.example.androidbasics.unit5.data.network.MarsApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val marsPhotosRepository: MarsPhotosRepository
}

class DefaultAppContainer : AppContainer {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }

    override val marsPhotosRepository: MarsPhotosRepository by lazy {
        NetworkMarsPhotosRepository(retrofitService)
    }

    private companion object {
         const val BASE_URL =
            "https://android-kotlin-fun-mars-server.appspot.com"
    }
}