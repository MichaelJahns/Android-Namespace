package com.michaeljahns.namespace.viewmodel.scenario

import com.michaeljahns.namespace.repository.pawn.Pawn
import com.michaeljahns.namespace.repository.scenario.Scenario
import com.michaeljahns.namespace.util.GlobalApplication
import com.michaeljahns.namespace.util.flattenJsonOnKey
import com.michaeljahns.namespace.util.rand
import com.michaeljahns.namespace.util.readJsonFromAsset
import com.michaeljahns.namespace.viewmodel.pawn.PawnFactory

object ScenarioFactory {
    fun getScenarios(count: Int): MutableList<Scenario> {
        val context = GlobalApplication.getAppContext()
        val locationJson = readJsonFromAsset(context, assetName = "pirateLocations.json")
        val scenarios = mutableListOf<Scenario>()
        repeat(count) {
            val scenario = randomScenario(locationJson)
            scenarios.add(scenario)
        }
        return scenarios
    }

    private fun randomScenario(JSON: String): Scenario {
        val flattenedLocation = flattenLocationFromJson(locationJSON = JSON)
        val scenarioPawns = randomPawns()
        return Scenario(flattenedLocation, scenarioPawns)
    }

    private fun randomPawns(crewSize: Int = generateCrewSize()): MutableList<Pawn> {
        return PawnFactory.getPawns(crewSize)
    }

    private fun flattenLocationFromJson(locationJSON: String, key: String = "origin"): String {
        return flattenJsonOnKey(locationJSON, key)
    }

    private fun generateCrewSize(): Int {
        val minCrewSize = 1
        val maxCrewSize = 6
        return rand(minCrewSize, maxCrewSize)
    }
}