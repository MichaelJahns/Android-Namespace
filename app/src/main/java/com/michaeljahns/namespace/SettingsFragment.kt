package com.michaeljahns.namespace

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.michaeljahns.namespace.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private var NUMBER_OF_SCENARIOS: Int? = null
    private var MINIMUM_PAWN_AGE: Int? = null
    private var MAXIMUM_PAWN_AGE: Int? = null
    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSettingsBinding.inflate(layoutInflater, container, false)
        binding.btnSaveSettings.setOnClickListener {
            saveData()
        }
        loadData()
        initSettings()
        return binding.root
    }

    private fun saveData() {
        val sharedPreferences = this.activity?.getSharedPreferences("persistentSettings", Context.MODE_PRIVATE)
        val numberOfScenariosInt = binding.dsNumberOfScenarios.value.toInt()
        val minimumPawnAgeRangeInt = binding.rsAgeRangeOfPawns.valueFrom.toInt()
        val maximumPawnAgeRangeInt = binding.rsAgeRangeOfPawns.valueTo.toInt()

        val editor = sharedPreferences?.edit()
        editor?.apply {
            putInt("NumberOfScenarios", numberOfScenariosInt)
            putInt("MinimumPawnAge", minimumPawnAgeRangeInt)
            putInt("MaximumPawnAge", maximumPawnAgeRangeInt)
        }?.apply()
    }

    private fun loadData() {
        val sharedPreferences = this.activity?.getSharedPreferences("persistentSettings", Context.MODE_PRIVATE)
        NUMBER_OF_SCENARIOS = sharedPreferences?.getInt("NumberOfScenarios", 15)
        MAXIMUM_PAWN_AGE = sharedPreferences?.getInt("MinimumPawnAge", 13)
        MINIMUM_PAWN_AGE = sharedPreferences?.getInt("MaximumPawnAge", 70)
        initSettings()
    }

    private fun initSettings() {
        setupDSNumberOfScenarios()
        setupRSAgeRangeOfPawns()
    }

    private fun setupDSNumberOfScenarios() {
        binding.dsNumberOfScenarios.setLabelFormatter {
            getString(R.string.label_Scenario, it)
        }
        binding.dsNumberOfScenarios.value = NUMBER_OF_SCENARIOS!!.toFloat()
    }

    private fun setupRSAgeRangeOfPawns() {
        binding.rsAgeRangeOfPawns.setLabelFormatter {
            getString(R.string.label_Age, it)
        }
        binding.rsAgeRangeOfPawns.valueTo = MINIMUM_PAWN_AGE!!.toFloat()
        binding.rsAgeRangeOfPawns.valueFrom = MAXIMUM_PAWN_AGE!!.toFloat()
    }
}