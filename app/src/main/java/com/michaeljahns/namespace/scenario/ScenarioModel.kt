package com.michaeljahns.namespace.scenario

import androidx.lifecycle.ViewModel

class ScenarioModel(private val scenarioRepository: ScenarioRepository)
    : ViewModel() {

    fun getScenarios() = scenarioRepository.getScenarios()
    fun clearScenarios() = scenarioRepository.clearScenarios()
    fun regenerateScenarios() = scenarioRepository.regenerateScenarios()
}


