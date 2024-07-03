package com.example.androidbasics.unit5.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class MarsPhoto(
    val id: String,
    val img_src: String
)
