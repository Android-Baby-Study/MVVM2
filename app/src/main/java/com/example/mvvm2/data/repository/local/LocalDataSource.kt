package com.example.mvvm2.data.repository.local

import com.example.mvvm2.App

interface LocalDataSource {
    val pref: SharedPreference
        get() = SharedPreference(App.instance.applicationContext)

    fun getHistory(): ArrayList<String>?
    fun setHistory(title:String)
}

class LocalDataSourceImpl():LocalDataSource{
    override fun getHistory(): ArrayList<String>? {
        return pref.getHistory()
    }

    override fun setHistory(title: String) {
        pref.setHistory(title)
    }
}
