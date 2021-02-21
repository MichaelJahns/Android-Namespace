package com.michaeljahns.namespace.forage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ForageDao {
    private var forageList = mutableListOf<Forage>()
    private val forages = MutableLiveData<List<Forage>>()

    init {
        regenerateForages()
    }

    fun getForages() = forages as LiveData<List<Forage>>

    fun clearForages() {
        forageList.clear()
    }

    private fun updateLiveData() {
        forages.value = forageList
    }

    fun regenerateForages() {
        clearForages()
        forageList = ForageFactory.getForages(7)
        updateLiveData()
    }
}
