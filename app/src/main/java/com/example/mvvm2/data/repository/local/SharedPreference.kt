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
        var history: ArrayList<String>? = if (getHistory().isNullOrEmpty()) arrayListOf() else getHistory()
        history!!.add(h)
        history = history.distinct() as ArrayList<String>

        if (history.size == 6) {
            history.removeAt(0)
        }
        pref.edit().putString(HISTORY, Gson().toJson(history)).apply()
    }
}