package com.example.mvvm2.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm2.data.model.Movie
import com.example.mvvm2.data.model.MovieResponse
import com.example.mvvm2.data.repository.Repository
import com.example.mvvm2.data.repository.RepositoryImpl
import com.example.mvvm2.data.repository.remote.BaseRetrofit
import com.example.mvvm2.data.repository.remote.MovieRetrofit
import retrofit2.Call
import retrofit2.Response

class MainViewModel :ViewModel() {
    var query:String = ""
    val movieList: MutableLiveData<ArrayList<Movie>> = MutableLiveData()
    val repository: RepositoryImpl = RepositoryImpl()

    fun getMoveList () {
        repository.setHistory(query)
        Log.d("로그",repository.getHistory().toString())
        repository.getMovieList(query).enqueue(object : retrofit2.Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful){
                    movieList.value = response.body()!!.items
                }
            }
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
            }
        }
        )

    }

}