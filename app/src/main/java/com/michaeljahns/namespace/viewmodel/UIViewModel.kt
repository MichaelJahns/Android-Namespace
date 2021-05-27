package com.michaeljahns.namespace.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UIViewModel : ViewModel() {
    var intView = MutableLiveData<Int>()
    var activeViewString = MutableLiveData<String>()
    fun select(int: Int) {
        intView.value = int
    }

    fun setActiveViewString(string: String) {
        activeViewString.value = string
    }
}