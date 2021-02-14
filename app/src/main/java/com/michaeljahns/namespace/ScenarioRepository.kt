package com.michaeljahns.namespace

class ScenarioRepository private constructor(private val scenarioDao: ScenarioDao) {

    fun clearScenarios() {
        scenarioDao.clearScenarios()
    }

    fun getScenarios() = scenarioDao.getScenarios()
    fun regenerateScenarios() = scenarioDao.regenerateScenarios()

    companion object {
        @Volatile
        private var instance: ScenarioRepository? = null

        fun getInstance(scenarioDao: ScenarioDao) =
                instance ?: synchronized(this) {
                    instance ?: ScenarioRepository(scenarioDao).also { instance = it }
                }
    }
}