package com.example.androidbasics.unit5.fake

import com.example.androidbasics.unit5.data.network.MarsApiService
import com.example.androidbasics.unit5.domain.models.MarsPhoto

class FakeMarsApiService : MarsApiService {
    override suspend fun getPhotos(): List<MarsPhoto> {
        return FakeDataSource.photosList
    }
}
