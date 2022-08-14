package com.example.silver_together.data

import androidx.annotation.DrawableRes

data class User(
    val name: String,
    @DrawableRes val imgRes: Int?,
    val userType: Int
)
