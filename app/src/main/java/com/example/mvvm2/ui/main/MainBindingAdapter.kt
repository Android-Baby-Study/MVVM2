package com.example.mvvm2.ui.main

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvm2.R
import com.example.mvvm2.data.model.Movie
import com.example.mvvm2.ui.history.HistoryRecyclerAdapter

@BindingAdapter("bind_movie_list")
fun setMovie(recyclerView: RecyclerView, movies:ArrayList<Movie>?){
    if (movies != null) {
        (recyclerView.adapter as MainRecyclerAdapter).movies = movies
        (recyclerView.adapter as MainRecyclerAdapter).notifyDataSetChanged()
    }
}

@BindingAdapter("bind_movie_image")
fun setImage(imageView: ImageView, url:String) {
    Glide.with(imageView.context)
        .load(url)
        .error(R.drawable.ic_launcher_foreground)
        .into(imageView)
}

@BindingAdapter("bind_history_list")
fun setHistory(recyclerView: RecyclerView, histories: ArrayList<String>?) {
    if (histories != null) {
        (recyclerView.adapter as HistoryRecyclerAdapter).setItem(histories)
    }
}