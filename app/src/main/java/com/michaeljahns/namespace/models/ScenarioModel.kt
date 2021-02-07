package com.michaeljahns.namespace.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.michaeljahns.namespace.factories.ScenarioFactory
import com.michaeljahns.namespace.grammy.Scenario

class ScenarioModel : ViewModel() {
    private var numberOfScenarios = MutableLiveData<Int>()
    private var scenarios: MutableList<Scenario> = ScenarioFactory.getScenarios(getNumberOfScenarios())

    private fun getNumberOfScenarios(): Int {
        return this.numberOfScenarios.value ?: 15
    }

    fun setNumberOfScenarios(number: Int) {
        this.numberOfScenarios.value = number
    }

    fun regenerateScenarios() {
        scenarios = ScenarioFactory.getScenarios(getNumberOfScenarios())
    }

    fun getScenarios(): MutableList<Scenario> {
        return this.scenarios
    }


}


