package com.example.mvvm2.data.repository.local

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object SharedPreference {
    private const val PREF_NAME = "PREF"
    private const val PREF_MODE = Context.MODE_PRIVATE
    private lateinit var pref:SharedPreferences

    fun init(context: Context) {
        pref = context.getSharedPreferences(PREF_NAME, PREF_MODE)
    }

    private const val HISTORY_KEY = "HISTORY"
    fun getHistory(): ArrayList<String>{
        val history = pref.getString(HISTORY_KEY, null)
        return Gson().fromJson(history, object : TypeToken<ArrayList<String>>() {}.type)}
    fun setHistory(h:String) {
        val history:ArrayList<String> = getHistory()
        if (history.size == 5) {
            history.removeAt(-1)
        }
        history.add(h)
        pref.edit().putString(HISTORY_KEY, Gson().toJson(history)).apply()
    }
}