package com.example.mvvm2.ui.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm2.data.model.Movie
import com.example.mvvm2.databinding.ItemMainBinding
import com.example.mvvm2.ui.moive.MovieActivity

class MainRecyclerAdapter(val movieClickListener: (Movie) -> Unit) :
    RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder>() {

    var movies: ArrayList<Movie> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
        holder.itemView.setOnClickListener { movieClickListener(movies[position]) }
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun setItem(movies: ArrayList<Movie>) {
        this.movies.clear()
        this.movies.addAll(movies)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemMainBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.movie = movie
        }
    }

}
