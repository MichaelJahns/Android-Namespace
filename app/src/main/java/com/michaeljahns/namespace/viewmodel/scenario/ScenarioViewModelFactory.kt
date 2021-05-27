package com.michaeljahns.namespace.viewmodel.scenario

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.michaeljahns.namespace.repository.scenario.ScenarioRepository

class ScenarioViewModelFactory(private val scenarioRepository: ScenarioRepository)
    : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ScenarioViewModel(scenarioRepository) as T
    }

}