package com.michaeljahns.namespace.scenario

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScenarioModel(private val scenarioRepository: ScenarioRepository)
    : ViewModel() {

    fun getScenarios() = scenarioRepository.getScenarios()
    fun clearScenarios() = scenarioRepository.clearScenarios()
    fun regenerateScenarios() = scenarioRepository.regenerateScenarios()

    var numberOfScenarios = MutableLiveData<Int>()
    private var minPawnAgeRange = MutableLiveData<Int>()
    private var maxPawnAgeRange = MutableLiveData<Int>()
    var isSettingsVisible = MutableLiveData<Boolean>()


    private fun getNumberOfScenarios(): Int {
        return this.numberOfScenarios.value ?: 15
    }

    fun getNumberOfScenariosFloat(): Float {
        val numberOfScenarios = this.numberOfScenarios.value?.toFloat()
        return numberOfScenarios ?: 15F
    }

    fun setNumberOfScenarios(number: Int) {
        this.numberOfScenarios.value = number
    }

    fun setPawnAgeRange(minimum: Int, maximum: Int) {
        this.minPawnAgeRange.value = minimum
        this.maxPawnAgeRange.value = maximum
    }


    fun getMinPawnAgeRange(): Float {
        val minAge = this.minPawnAgeRange.value?.toFloat()
        return minAge ?: 10F
    }

    fun getMaxPawnAgeRange(): Float {
        val maxAge = this.maxPawnAgeRange.value?.toFloat()
        return maxAge ?: 70F
    }

    fun toggleSettingsVisibility() {
        isSettingsVisible.value = isSettingsVisible.value!!.not()
    }

    init {
        isSettingsVisible.value = false
    }


}


