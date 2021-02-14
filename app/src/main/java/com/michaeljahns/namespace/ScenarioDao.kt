package com.michaeljahns.namespace

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.michaeljahns.namespace.factories.ScenarioFactory
import com.michaeljahns.namespace.grammy.Scenario

class ScenarioDao {
    private var scenarioList = mutableListOf<Scenario>()
    private val scenarios = MutableLiveData<List<Scenario>>()

    init {
        scenarios.value = scenarioList
    }

    fun getScenarios() = scenarios as LiveData<List<Scenario>>

    fun clearScenarios() {
        scenarioList.clear()
    }

    fun updateDataLiveData() {
        scenarios.value = scenarioList
    }

    fun regenerateScenarios() {
        clearScenarios()
        scenarioList = ScenarioFactory.getScenarios(5)
        updateDataLiveData()
    }
}