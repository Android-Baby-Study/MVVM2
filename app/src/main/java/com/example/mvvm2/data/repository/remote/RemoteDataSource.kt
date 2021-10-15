package com.example.mvvm2.data.repository.remote

import com.example.mvvm2.data.model.Movie
import com.example.mvvm2.data.model.MovieResponse
import retrofit2.Call
import retrofit2.Response

interface RemoteDataSource {
    fun getMovieList(query: String):Call<MovieResponse>
}

class RemoteDataSourceImpl() : RemoteDataSource {

    override fun getMovieList(query: String): Call<MovieResponse> {
        return BaseRetrofit.retrofit.create(MovieRetrofit::class.java).getMovieList(query)
    }
}