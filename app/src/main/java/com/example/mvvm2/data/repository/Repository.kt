package com.example.mvvm2.data.repository

import com.example.mvvm2.data.model.MovieResponse
import com.example.mvvm2.data.repository.local.LocalDataSource
import com.example.mvvm2.data.repository.local.LocalDataSourceImpl
import com.example.mvvm2.data.repository.remote.RemoteDataSourceImpl
import retrofit2.Call

interface Repository {
    val remoteDataSource: RemoteDataSourceImpl
    val localDataSource: LocalDataSourceImpl

    fun getMovieList(query: String): Call<MovieResponse>
    fun getHistory(): ArrayList<String>?
    fun setHistory(title:String)
}

class RepositoryImpl() : Repository {
    override val remoteDataSource: RemoteDataSourceImpl
        get() = RemoteDataSourceImpl()
    override val localDataSource: LocalDataSourceImpl
        get() = LocalDataSourceImpl()

    override fun getMovieList(query: String): Call<MovieResponse> {
        return remoteDataSource.getMovieList(query)
    }

    override fun getHistory(): ArrayList<String>? {
        return localDataSource.getHistory()
    }

    override fun setHistory(title: String) {
        return localDataSource.setHistory(title)
    }
}