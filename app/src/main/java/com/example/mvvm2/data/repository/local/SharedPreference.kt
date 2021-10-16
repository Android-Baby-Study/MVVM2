package com.example.mvvm2.data.repository.local

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.mvvm2.App
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SharedPreference(context: Context) {
    private val PREF_NAME = "PREF"
    private val PREF_MODE = Context.MODE_PRIVATE
    private var pref: SharedPreferences = context.getSharedPreferences(PREF_NAME, PREF_MODE)


    private val HISTORY = "HISTORY"
    fun getHistory(): ArrayList<String>? {
        val history = pref.getString(HISTORY, null)
        return Gson().fromJson(history, object : TypeToken<ArrayList<String>>() {}.type)
    }

    fun setHistory(h: String) {
        var history: ArrayList<String>? = getHistory()
        if (history != null) {
            if (history.size == 5) {
                history.removeAt(0)
            }
        }
        else {
            history = arrayListOf()
        }
        history.add(h)
        pref.edit().putString(HISTORY, Gson().toJson(history)).apply()
    }
}