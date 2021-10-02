package com.example.mvvm2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm2.R
import com.example.mvvm2.data.model.Movie
import com.example.mvvm2.databinding.ActivityMainBinding
import com.example.mvvm2.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity() {

    private lateinit var vm : MovieViewModel
    private lateinit var binding: ActivityMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        val movie: Movie = intent.extras?.getSerializable("movie") as Movie

        // viewmodel
        vm = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[MovieViewModel::class.java]

        vm.movie = movie

        // binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        binding.vm = vm
        binding.lifecycleOwner = this

    }
}