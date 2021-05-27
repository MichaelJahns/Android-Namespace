package com.michaeljahns.namespace.viewmodel.scenario

import androidx.lifecycle.ViewModel
import com.michaeljahns.namespace.repository.scenario.ScenarioRepository

class ScenarioViewModel(private val scenarioRepository: ScenarioRepository)
    : ViewModel() {

    fun getScenarios() = scenarioRepository.getScenarios()
    fun clearScenarios() = scenarioRepository.clearScenarios()
    fun regenerateScenarios() = scenarioRepository.regenerateScenarios()
}


