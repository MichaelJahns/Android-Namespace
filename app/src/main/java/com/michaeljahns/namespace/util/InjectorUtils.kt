package com.michaeljahns.namespace.util

import com.michaeljahns.namespace.database.ForageDatabase
import com.michaeljahns.namespace.database.ScenarioDatabase
import com.michaeljahns.namespace.repository.forage.ForageRepository
import com.michaeljahns.namespace.repository.scenario.ScenarioRepository
import com.michaeljahns.namespace.viewmodel.forage.ForageViewModelFactory
import com.michaeljahns.namespace.viewmodel.scenario.ScenarioViewModelFactory

object InjectorUtils {

    fun provideScenarioModelFactory(): ScenarioViewModelFactory {
        val scenarioRepository = ScenarioRepository.getInstance(ScenarioDatabase.getInstance().scenarioDao)
        return ScenarioViewModelFactory(scenarioRepository)
    }

    fun provideForageModelFactory(): ForageViewModelFactory {
        val forageRepository = ForageRepository.getInstance(ForageDatabase.getInstance().forageDao)
        return ForageViewModelFactory(forageRepository)
    }
}