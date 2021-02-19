package com.michaeljahns.namespace

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