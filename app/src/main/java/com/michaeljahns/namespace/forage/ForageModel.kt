package com.michaeljahns.namespace.forage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ForageModel : ViewModel() {
    var numberOfForages = MutableLiveData<Int>()
    var forages: MutableLiveData<MutableList<Forage>> = ForageFactory.getForages(getNumberOfForages())

    private fun getNumberOfForages(): Int {
        return this.numberOfForages.value ?: 16
    }
}