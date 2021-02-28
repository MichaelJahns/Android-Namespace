package com.michaeljahns.namespace.scenario

class ScenarioDatabase private constructor() {

//    This is fake as hell,
//    just made so i could pretend to have a db while building other features


    var scenarioDao = ScenarioDao()
        private set

    companion object {
        @Volatile
        private var instance: ScenarioDatabase? = null

        fun getInstance() =
                instance ?: synchronized(this) {
                    instance ?: ScenarioDatabase().also {
                        instance = it
                    }
                }
    }
}