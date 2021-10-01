package com.example.mvvm2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvm2.R

/**
 * api doc = https://developers.naver.com/docs/search/movie/ \
 * **/
class MainActivity : AppCompatActivity() {
    private val clientId: String = "KPs1Fz7hGzcZRPFvViN7"
    private val clientSecret: String = "qm06FtUOJ8"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}