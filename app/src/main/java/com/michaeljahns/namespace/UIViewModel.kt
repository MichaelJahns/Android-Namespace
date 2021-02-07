package com.michaeljahns.namespace

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UIViewModel : ViewModel() {
    var intView = MutableLiveData<Int>()
    fun select(int: Int) {
        intView.value = int
    }
}