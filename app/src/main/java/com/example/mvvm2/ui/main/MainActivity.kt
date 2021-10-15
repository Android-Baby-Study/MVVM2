package com.example.mvvm2.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm2.R
import com.example.mvvm2.databinding.ActivityMainBinding
import com.example.mvvm2.ui.moive.MovieActivity
import javax.security.auth.callback.Callback
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private lateinit var vm : MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // viewmodel
        vm = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[MainViewModel::class.java]

        // binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.vm = vm
        binding.lifecycleOwner = this
        binding.mainMovieRecycler.adapter = MainRecyclerAdapter(){
            val movieIntent = Intent(this, MovieActivity::class.java).apply {
                putExtra("movie", it)
            }
            startActivity(movieIntent)
        }
    }
}
