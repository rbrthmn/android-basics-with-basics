package com.example.androidbasics.unit5.data

import com.example.androidbasics.unit5.data.network.MarsApi
import com.example.androidbasics.unit5.domain.models.MarsPhoto

interface MarsPhotosRepository {
    suspend fun getMarsPhotos(): List<MarsPhoto>
}

class NetworkMarsPhotosRepository() : MarsPhotosRepository {
    override suspend fun getMarsPhotos(): List<MarsPhoto> {
        return MarsApi.retrofitService.getPhotos()
    }

}