package com.michaeljahns.namespace.repository.forage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.michaeljahns.namespace.viewmodel.forage.ForageFactory

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
