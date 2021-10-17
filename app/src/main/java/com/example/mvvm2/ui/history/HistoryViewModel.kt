package com.example.mvvm2.ui.history

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm2.data.repository.RepositoryImpl

class HistoryViewModel:ViewModel() {
    val repository:RepositoryImpl = RepositoryImpl()

    val historyList: MutableLiveData<ArrayList<String>?> = MutableLiveData()

    fun getHistory () {
        historyList.value = repository.getHistory()
    }
}