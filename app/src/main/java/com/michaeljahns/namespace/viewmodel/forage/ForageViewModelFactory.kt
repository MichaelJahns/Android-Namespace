package com.michaeljahns.namespace.viewmodel.forage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.michaeljahns.namespace.repository.forage.ForageRepository

class ForageViewModelFactory(private val forageRepository: ForageRepository)
    : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ForageViewModel(forageRepository) as T
    }
}