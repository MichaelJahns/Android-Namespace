package com.michaeljahns.namespace.util

import com.michaeljahns.namespace.scenario.ScenarioDatabase
import com.michaeljahns.namespace.scenario.ScenarioModelFactory
import com.michaeljahns.namespace.scenario.ScenarioRepository

object InjectorUtils {

    fun provideScenarioModelFactory(): ScenarioModelFactory {
        val scenarioRepository = ScenarioRepository.getInstance(ScenarioDatabase.getInstance().scenarioDao)
        return ScenarioModelFactory(scenarioRepository)
    }
}