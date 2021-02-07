package com.michaeljahns.namespace.factories

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.michaeljahns.namespace.GlobalApplication
import com.michaeljahns.namespace.flattenLocationsFromJson
import com.michaeljahns.namespace.grammy.Location
import com.michaeljahns.namespace.grammy.Pawn
import com.michaeljahns.namespace.grammy.Scenario
import com.michaeljahns.namespace.rand
import com.michaeljahns.namespace.readJsonFromAsset

object ScenarioFactory {
    fun getScenarios(count: Int): MutableLiveData<List<Scenario>> {
        val scenarios: MutableLiveData<List<Scenario>> = MutableLiveData()
        repeat(count) {
            val context = GlobalApplication.getAppContext()
            val scenarioLocation = randomLocation(context)
            val scenarioPawns = randomPawns(context)
            var scenario = Scenario(scenarioLocation, scenarioPawns)
            scenarios.postValue(listOf(scenario))
        }
        return scenarios
    }

    private fun randomLocation(context: Context): Location {
        val locationJson = readJsonFromAsset(context, "pirateLocations.json")
        return flattenLocationsFromJson(locationJson)
    }

    private fun randomPawns(context: Context): MutableList<Pawn> {
        return PawnFactory.getPawns(context, generateCrewSize())
    }

    private fun generateCrewSize(): Int {
        val minCrewSize = 1
        val maxCrewSize = 5
        return rand(minCrewSize, maxCrewSize)
    }
}