package com.example.mvvm2.data.repository.local

interface LocalDataSource {
    val pref: SharedPreference
        get() = SharedPreference

    fun getHistory(): ArrayList<String>
    fun setHistory(title:String)
}

class LocalDataSourceImpl():LocalDataSource{
    override fun getHistory(): ArrayList<String> {
        return pref.getHistory()
    }

    override fun setHistory(title: String) {
        pref.setHistory(title)
    }
}
