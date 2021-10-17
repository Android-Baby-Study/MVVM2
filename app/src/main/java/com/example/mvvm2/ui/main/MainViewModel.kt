package com.example.mvvm2.ui.main

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm2.App
import com.example.mvvm2.data.model.Movie
import com.example.mvvm2.data.model.MovieResponse
import com.example.mvvm2.data.repository.Repository
import com.example.mvvm2.data.repository.RepositoryImpl
import com.example.mvvm2.data.repository.remote.BaseRetrofit
import com.example.mvvm2.data.repository.remote.MovieRetrofit
import com.example.mvvm2.ui.history.HistoryActivity
import retrofit2.Call
import retrofit2.Response

class MainViewModel :ViewModel() {
    var query:String = ""
    var empty:MutableLiveData<Boolean> = MutableLiveData(false)
    val movieList: MutableLiveData<ArrayList<Movie>> = MutableLiveData()
    val repository: RepositoryImpl = RepositoryImpl()

    fun getMoveList () {
        repository.setHistory(query)
        repository.getMovieList(query).enqueue(object : retrofit2.Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful){
                    movieList.value = response.body()!!.items
                    empty.value = movieList.value!!.size == 0
                }
            }
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Toast.makeText(App.instance.applicationContext, "검색 도중 오류가 발생했습니다.", Toast.LENGTH_SHORT).show()
            }
        }
        )
    }

}