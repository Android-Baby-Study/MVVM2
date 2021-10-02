package com.example.mvvm2.data.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BaseRetrofit {
    private const val BASE_URL = "https://openapi.naver.com"
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}