package com.michaeljahns.namespace

import android.content.Context
import com.michaeljahns.namespace.grammy.Location
import com.michaeljahns.namespace.grammy.Pawn
import com.michaeljahns.namespace.grammy.Scenario

class ScenarioFactory {
    fun getScenarios(count: Int): List<Scenario> {
        val scenarios = mutableListOf<Scenario>()
        repeat(count) {
            val context = GlobalApplication.getAppContext()
            val scenarioLocation = randomLocation(context)
            val scenarioPawns = randomPawns(context)
            val scenario = Scenario(scenarioLocation, scenarioPawns)
            scenarios.add(scenario)
        }
        return scenarios
    }

    private fun randomLocation(context: Context): Location {
        val locationJson = readJsonFromAsset(context, "pirateLocations.json")
        return flattenLocationsFromJson(locationJson)
    }

    private fun randomPawns(context: Context): List<Pawn> {
        val pawnJson = readJsonFromAsset(context, "pirateNames.json")
        val scenarioPawnList = mutableListOf<Pawn>()
        for (j in 1..generateCrewSize()) {
            val scenarioPawn = randomPawn(pawnJson)
            scenarioPawnList.add(scenarioPawn)
        }
        return scenarioPawnList
    }

    private fun randomPawn(JSON: String?): Pawn {
        val pawnName = flattenJsonOnKey(JSON, "name")
        val pawnAge = generatePawnAge()
        val pawnProfession = flattenJsonOnKey(JSON, "profession")
        return Pawn(pawnName, pawnAge, pawnProfession)
    }

    private fun generatePawnAge(): Int {
        val minAge = 13
        val maxAge = 69
        return rand(minAge, maxAge)
    }

    private fun generateCrewSize(): Int {
        val minCrewSize = 1
        val maxCrewSize = 5
        return rand(minCrewSize, maxCrewSize)
    }
}