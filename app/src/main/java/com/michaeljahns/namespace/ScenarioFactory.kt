package com.michaeljahns.namespace

import android.content.Context
import com.michaeljahns.namespace.grammy.Location
import com.michaeljahns.namespace.grammy.Pawn
import com.michaeljahns.namespace.grammy.Scenario

object ScenarioFactory {
    fun getScenarios(count: Int): MutableList<Scenario> {
        val scenarios = mutableListOf<Scenario>()
        repeat(count) {
            val context = GlobalApplication.getAppContext()
            val scenarioLocation = randomLocation(context)
            val scenarioPawns = randomPawns()
            val scenario = Scenario(scenarioLocation, scenarioPawns)
            scenarios.add(scenario)
        }
        return scenarios
    }

    private fun randomLocation(context: Context): Location {
        val locationJson = readJsonFromAsset(context, "pirateLocations.json")
        return flattenLocationsFromJson(locationJson)
    }

    private fun randomPawns(): MutableList<Pawn> {
        return PawnFactory.getPawns(generateCrewSize())
    }

    private fun generateCrewSize(): Int {
        val minCrewSize = 1
        val maxCrewSize = 5
        return rand(minCrewSize, maxCrewSize)
    }
}