package com.example.androidbasics.unit5.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MarsPhoto(
    val id: String,
//    @SerialName(value = "img_src")
    val img_src: String
)
