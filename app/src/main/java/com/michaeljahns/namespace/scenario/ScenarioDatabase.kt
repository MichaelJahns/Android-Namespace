package com.michaeljahns.namespace.scenario

class ScenarioDatabase private constructor() {

    var scenarioDao = ScenarioDao()
        private set

    companion object {
        @Volatile
        private var instance: ScenarioDatabase? = null

        fun getInstance() =
                instance ?: synchronized(this) {
                    instance ?: ScenarioDatabase().also { instance = it }
                }
    }
}