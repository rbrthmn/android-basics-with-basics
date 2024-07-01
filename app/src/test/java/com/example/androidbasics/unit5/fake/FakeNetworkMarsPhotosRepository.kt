package com.example.androidbasics.unit5.fake

import com.example.androidbasics.unit5.data.MarsPhotosRepository
import com.example.androidbasics.unit5.domain.models.MarsPhoto

class FakeNetworkMarsPhotosRepository : MarsPhotosRepository {
    override suspend fun getMarsPhotos(): List<MarsPhoto> {
        return FakeMarsApiService().getPhotos()
    }
}
