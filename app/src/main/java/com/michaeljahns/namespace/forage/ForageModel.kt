package com.michaeljahns.namespace.forage

import androidx.lifecycle.ViewModel

class ForageModel(private val forageRepository: ForageRepository)
    : ViewModel() {

    fun getForages() = forageRepository.getForages()
    fun regenerateForages() = forageRepository.regenerateForages()
    fun clearForages() = forageRepository.clearForages()
}