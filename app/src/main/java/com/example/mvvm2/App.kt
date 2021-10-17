package com.example.mvvm2

import android.app.Application
import android.content.SharedPreferences
import com.example.mvvm2.data.repository.local.SharedPreference

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: App
    }
}