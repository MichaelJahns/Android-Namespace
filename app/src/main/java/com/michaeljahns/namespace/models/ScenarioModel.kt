package com.michaeljahns.namespace.models

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.michaeljahns.namespace.ScenarioRepository
import com.michaeljahns.namespace.factories.ScenarioFactory
import com.michaeljahns.namespace.grammy.Scenario

class ScenarioModel(private val scenarioRepository: ScenarioRepository)
    : ViewModel() {

    fun getScenarios() = scenarioRepository.getScenarios()
    fun clearScenarios() = scenarioRepository.clearScenarios()
    var numberOfScenarios = MutableLiveData<Int>()
    private var minPawnAgeRange = MutableLiveData<Int>()
    private var maxPawnAgeRange = MutableLiveData<Int>()
    var scenarios: MutableLiveData<MutableList<Scenario>> = ScenarioFactory.getScenarios(getNumberOfScenarios())
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

    fun regenerateScenarios() {
        Log.d("ScenModel", scenarios.value!![1].location.toString())
        scenarios.value?.clear()
        scenarios = ScenarioFactory.getScenarios(getNumberOfScenarios())
        Log.d("ScenModel2", scenarios.value!![1].location.toString())
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


