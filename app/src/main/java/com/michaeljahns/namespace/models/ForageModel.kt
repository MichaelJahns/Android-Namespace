package com.michaeljahns.namespace.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.michaeljahns.namespace.factories.ForageFactory
import com.michaeljahns.namespace.grammy.Forage

class ForageModel : ViewModel() {
    var numberOfForages = MutableLiveData<Int>()
    var forages: MutableLiveData<MutableList<Forage>> = ForageFactory.getForages(getNumberOfForages())

    private fun getNumberOfForages(): Int {
        return this.numberOfForages.value ?: 16
    }
}