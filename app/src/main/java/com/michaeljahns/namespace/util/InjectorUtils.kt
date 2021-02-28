package com.michaeljahns.namespace.util

import com.michaeljahns.namespace.forage.ForageDatabase
import com.michaeljahns.namespace.forage.ForageModelFactory
import com.michaeljahns.namespace.forage.ForageRepository
import com.michaeljahns.namespace.scenario.ScenarioDatabase
import com.michaeljahns.namespace.scenario.ScenarioModelFactory
import com.michaeljahns.namespace.scenario.ScenarioRepository

object InjectorUtils {

    fun provideScenarioModelFactory(): ScenarioModelFactory {
        val scenarioRepository = ScenarioRepository.getInstance(ScenarioDatabase.getInstance().scenarioDao)
        return ScenarioModelFactory(scenarioRepository)
    }

    fun provideForageModelFactory(): ForageModelFactory {
        val forageRepository = ForageRepository.getInstance(ForageDatabase.getInstance().forageDao)
        return ForageModelFactory(forageRepository)
    }

    fun providePawnModelFactory(): PawnModelFactory {
        val pawnRepository = PawnRepository.getInstance(pawnDatabase.getInstance().pawnDao)
        return PawnModelFactory(pawnRepository)
    }
}