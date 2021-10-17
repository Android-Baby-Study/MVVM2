package com.example.mvvm2.ui.history

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm2.R
import com.example.mvvm2.databinding.ActivityHistoryBinding
import com.example.mvvm2.databinding.ActivityMainBinding
import com.example.mvvm2.ui.main.MainActivity
import com.example.mvvm2.ui.main.MainRecyclerAdapter
import com.example.mvvm2.ui.main.MainViewModel
import com.example.mvvm2.ui.moive.MovieActivity

class HistoryActivity : AppCompatActivity() {
    private lateinit var  vm:HistoryViewModel
    private lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //viewmodel
        vm = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[HistoryViewModel::class.java]
        vm.getHistory()

        //binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_history)
        binding.vm = vm
        binding.lifecycleOwner = this
        binding.historyRecycler.adapter = HistoryRecyclerAdapter(){
            val mainIntent = Intent(this, MainActivity::class.java).apply {
                putExtra("title", it)
            }
            startActivity(mainIntent)
        }

    }
}