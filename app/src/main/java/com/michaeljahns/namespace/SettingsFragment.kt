package com.michaeljahns.namespace

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment

private val NUMBER_OF_SCENARIOS = 15
private val MINIMUM_PAWN_AGE = 13
private val MAXIMUM_PAWN_AGE = 71

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private var NUMBER_OF_SCENARIOS: Int? = null
    private var MINIMUM_PAWN_AGE: Int? = null
    private var MAXIMUM_PAWN_AGE: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            NUMBER_OF_SCENARIOS = it.getInt("NUMBER_OF_SCENARIOS", 15)
            MINIMUM_PAWN_AGE = it.getInt("MINIMUM_PAWN_AGE", 13)
            MAXIMUM_PAWN_AGE = it.getInt("MAXIMUM_PAWN_AGE", 71)
        }
    }

    private fun saveData() {
        val sharedPreferences = this.activity?.getSharedPreferences("persistentSettings", Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        editor.apply {

        }?.apply()
    }

    private fun loadData() {
        val dsNumberOfScenarios = R.id.dsNumberOfScenarios
        val rsAgeRangeOfPawns = R.id.rsAgeRangeOfPawns
        val preferences = this.activity?.getSharedPreferences("persistentSettings", Context.MODE_PRIVATE)
        val NumberOfScenarios = preferences?.getInt("NumberOfScenarios", 15)
        val MinimumPawnAge = preferences?.getInt("MinimumPawnAge", 13)
        val MaximumPawnAge = preferences?.getInt("MaximumPawnAge", 70)
    }

    companion object {
        fun newInstance(param1: Int, param2: Int, param3: Int) =
                SettingsFragment().apply {
                    arguments = Bundle().apply {
                        putInt("NUMBER_OF_SCENARIOS", param1)
                        putInt("MINIMUM_PAWN_AGE", param2)
                        putInt("MAXIMUM_PAWN_AGE", param3)
                    }
                }
    }
}