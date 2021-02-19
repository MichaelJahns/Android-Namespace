package com.michaeljahns.namespace.util

import com.michaeljahns.namespace.ScenarioDatabase
import com.michaeljahns.namespace.ScenarioModelFactory
import com.michaeljahns.namespace.ScenarioRepository

object InjectorUtils {

    fun provideScenarioModelFactory(): ScenarioModelFactory {
        val scenarioRepository = ScenarioRepository.getInstance(ScenarioDatabase.getInstance().scenarioDao)
        return ScenarioModelFactory(scenarioRepository)
    }
}