package com.michaeljahns.namespace.viewmodel.forage

import androidx.lifecycle.ViewModel
import com.michaeljahns.namespace.repository.forage.ForageRepository

class ForageViewModel(private val forageRepository: ForageRepository)
    : ViewModel() {

    fun getForages() = forageRepository.getForages()
    fun clearForages() = forageRepository.clearForages()
    fun regenerateForages() = forageRepository.regenerateForages()
}