package com.example.mvvm2.data.repository

import com.example.mvvm2.data.model.MovieResponse
import com.example.mvvm2.data.repository.remote.RemoteDataSourceImpl
import retrofit2.Call

interface Repository {
    val remoteDataSource : RemoteDataSourceImpl
    fun getMovieList(query: String) :Call<MovieResponse>
}

class RepositoryImpl() : Repository {
    override val remoteDataSource: RemoteDataSourceImpl
        get() = RemoteDataSourceImpl()

    override fun getMovieList(query: String): Call<MovieResponse> {
        return remoteDataSource.getMovieList(query)

    }
}