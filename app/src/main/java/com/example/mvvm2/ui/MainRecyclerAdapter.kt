package com.example.mvvm2.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm2.data.model.Movie
import com.example.mvvm2.databinding.ItemMainBinding

class MainRecyclerAdapter : RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder>() {
    var movies = ArrayList<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun setItem(movies : ArrayList<Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemMainBinding) :RecyclerView.ViewHolder(binding.root) {
        fun bind (movie:Movie) {
            binding.movie = movie
        }
    }
}
