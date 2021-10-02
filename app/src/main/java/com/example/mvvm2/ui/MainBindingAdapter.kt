package com.example.mvvm2.ui

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvm2.R
import com.example.mvvm2.data.model.Movie

@BindingAdapter("bind_movie_list")
fun setMovie(recyclerView: RecyclerView, movies:ArrayList<Movie>?){

    if (recyclerView.adapter === null) {

        val lm = LinearLayoutManager(recyclerView.context)
        val adapter = MainRecyclerAdapter()
        recyclerView.layoutManager = lm
        recyclerView.adapter = adapter
    }
    if (movies != null) {
        (recyclerView.adapter as MainRecyclerAdapter).movies = movies
        (recyclerView.adapter as MainRecyclerAdapter).setItem(movies)
    }
}

@BindingAdapter("bind_movie_image")
fun setImage(imageView: ImageView, url:String) {
    Glide.with(imageView.context)
        .load(url)
        .error(R.drawable.ic_launcher_foreground)
        .into(imageView)
}