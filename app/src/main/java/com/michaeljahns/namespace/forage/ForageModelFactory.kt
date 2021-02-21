package com.michaeljahns.namespace.forage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ForageModelFactory(private val forageRepository: ForageRepository)
    : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ForageModel(forageRepository) as T
    }
}