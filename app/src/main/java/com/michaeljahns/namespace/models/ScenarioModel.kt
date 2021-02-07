package com.michaeljahns.namespace.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.michaeljahns.namespace.factories.ScenarioFactory
import com.michaeljahns.namespace.grammy.Scenario

class ScenarioModel : ViewModel() {
    private var scenarios: MutableLiveData<List<Scenario>> = MutableLiveData()
//        get() {
//            return ScenarioFactory.getScenarios(numberOfScenarios)
//        }


    fun generateScenarios() {
        val numberOfScenarios = 13
        scenarios = ScenarioFactory.getScenarios(numberOfScenarios)
    }

    fun getScenarios(): MutableLiveData<List<Scenario>> {
        return this.scenarios
    }
}


