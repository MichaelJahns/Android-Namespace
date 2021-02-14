package com.michaeljahns.namespace

class ScenarioRepository private constructor(private val scenarioDao: ScenarioDao) {

    fun getScenarios() = scenarioDao.getScenarios()
    fun regenerateScenarios() = scenarioDao.regenerateScenarios()
    fun clearScenarios() = scenarioDao.clearScenarios()

    companion object {
        @Volatile
        private var instance: ScenarioRepository? = null

        fun getInstance(scenarioDao: ScenarioDao) =
                instance ?: synchronized(this) {
                    instance ?: ScenarioRepository(scenarioDao).also { instance = it }
                }
    }
}