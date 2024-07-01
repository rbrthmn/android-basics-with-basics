package com.example.androidbasics.unit5.data

import com.example.androidbasics.unit5.data.network.MarsApiService
import com.example.androidbasics.unit5.domain.models.MarsPhoto

interface MarsPhotosRepository {
    suspend fun getMarsPhotos(): List<MarsPhoto>
}

class NetworkMarsPhotosRepository(private val marsApiService: MarsApiService) : MarsPhotosRepository {
    override suspend fun getMarsPhotos(): List<MarsPhoto> {
        return marsApiService.getPhotos()
    }
}