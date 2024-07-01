package com.example.androidbasics.unit5.data.network

import com.example.androidbasics.unit5.domain.models.MarsPhoto
import retrofit2.http.GET

interface MarsApiService {
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}
