package com.michaeljahns.namespace

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.michaeljahns.namespace.grammy.Scenario

class ScenarioDao {
    private val scenarioList = mutableListOf<Scenario>()
    private val scenarios = MutableLiveData<List<Scenario>>()

    init {
        scenarios.value = scenarioList
    }

    fun clearScenarios() {
        scenarioList.clear()
    }

    fun getScenarios() = scenarios as LiveData<List<Scenario>>
}