package com.michaeljahns.namespace.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.michaeljahns.namespace.R
import com.michaeljahns.namespace.databinding.FragmentSettingsBinding
import com.michaeljahns.namespace.models.ScenarioModel

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private lateinit var binding: FragmentSettingsBinding
    private val model: ScenarioModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSettingsBinding.inflate(layoutInflater, container, false)
        binding.btnSaveSettings.setOnClickListener {
            saveData()
        }
        initSettings()
        return binding.root
    }

    private fun saveData() {
        val numberOfScenariosInt = binding.dsNumberOfScenarios.value.toInt()
        val minimumPawnAgeRangeInt = binding.rsAgeRangeOfPawns.valueFrom.toInt()
        val maximumPawnAgeRangeInt = binding.rsAgeRangeOfPawns.valueTo.toInt()

        model.setNumberOfScenarios(numberOfScenariosInt)
        model.setPawnAgeRange(minimumPawnAgeRangeInt, maximumPawnAgeRangeInt)
    }

    private fun initSettings() {
        setupDSNumberOfScenarios()
        setupRSAgeRangeOfPawns()
    }

    private fun setupDSNumberOfScenarios() {
        binding.dsNumberOfScenarios.setLabelFormatter {
            getString(R.string.label_Scenario, it)
        }
        binding.dsNumberOfScenarios.value = model.getNumberOfScenariosFloat()
    }

    private fun setupRSAgeRangeOfPawns() {
        binding.rsAgeRangeOfPawns.setLabelFormatter {
            getString(R.string.label_Age, it)
        }
        binding.rsAgeRangeOfPawns.valueFrom = model.getMinPawnAgeRange()
        binding.rsAgeRangeOfPawns.valueTo = model.getMaxPawnAgeRange()
    }
}