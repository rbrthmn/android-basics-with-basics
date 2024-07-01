package com.example.androidbasics.unit5

import com.example.androidbasics.unit5.data.NetworkMarsPhotosRepository
import com.example.androidbasics.unit5.fake.FakeDataSource
import com.example.androidbasics.unit5.fake.FakeMarsApiService
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkMarsRepositoryTest {
    @Test
    fun networkMarsPhotosRepository_getMarsPhotos_verifyPhotoList(): Unit = runTest {
        val repository = NetworkMarsPhotosRepository(
            marsApiService = FakeMarsApiService()
        )
        assertEquals(FakeDataSource.photosList, repository.getMarsPhotos())
    }
}