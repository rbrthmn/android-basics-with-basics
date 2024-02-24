package com.example.androidbasics.unit3.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic (
    @StringRes val stringResourceId: Int,
    val coursesNumber: Int,
    @DrawableRes val imageResourceId: Int
)