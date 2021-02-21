package com.michaeljahns.namespace.scenario

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ScenarioModelFactory(private val scenarioRepository: ScenarioRepository)
    : ViewModelProvider.NewInstanceFactory() {
    
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ScenarioModel(scenarioRepository) as T
    }

}