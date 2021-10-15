package com.example.mvvm2.data.repository.remote

import com.example.mvvm2.data.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface MovieRetrofit {

    @Headers (
        "X-Naver-Client-Id: KPs1Fz7hGzcZRPFvViN7",
        "X-Naver-Client-Secret: qm06FtUOJ8"
    )
    @GET("/v1/search/movie.json")
    fun getMovieList(
        @Query("query") query: String
    ) : Call<MovieResponse>
}