package com.example.mvvm2.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm2.data.model.Movie
import com.example.mvvm2.data.model.MovieResponse
import com.example.mvvm2.data.repository.BaseRetrofit
import com.example.mvvm2.data.repository.MovieRetrofit
import retrofit2.Call
import retrofit2.Response

class MainViewModel :ViewModel() {
    var query:String = "Harry potter"
    val movieList: MutableLiveData<ArrayList<Movie>> = MutableLiveData()

    fun getMoveList () {
        val api = BaseRetrofit.retrofit.create(MovieRetrofit::class.java).getMovieList(query)

        api.enqueue(object : retrofit2.Callback<MovieResponse> {
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