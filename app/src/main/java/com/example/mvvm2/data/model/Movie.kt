package com.example.mvvm2.data.model

import java.io.Serializable

data class Movie(
    val title: String,
    val image: String,
    val userRating: String,
    val director: String,
    val actor: String
):Serializable