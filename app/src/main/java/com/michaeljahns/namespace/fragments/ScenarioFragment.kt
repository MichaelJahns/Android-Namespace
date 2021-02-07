package com.michaeljahns.namespace.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.michaeljahns.namespace.R
import com.michaeljahns.namespace.ScenarioPageAdapter
import com.michaeljahns.namespace.databinding.FragmentScenarioBinding
import com.michaeljahns.namespace.factories.ScenarioFactory
import com.michaeljahns.namespace.grammy.Scenario
import com.michaeljahns.namespace.models.ScenarioModel

class ScenarioFragment : Fragment(R.layout.fragment_scenario) {
    private var numberOfScenarios: Int = 15
    private lateinit var binding: FragmentScenarioBinding
    private var scenarioList = mutableListOf<Scenario>()
    private val model: ScenarioModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentScenarioBinding.inflate(layoutInflater, container, false)
        startViewPager()
        return binding.root
    }
//Observe changes in the settings to reroll Scenarios
//
//    private fun loadData() {
//        val sharedPreferences = this.activity?.getSharedPreferences("persistentSettings", Context.MODE_PRIVATE)
//        numberOfScenarios = sharedPreferences?.getInt("NumberOfScenarios", 15)!!
//    }

    private fun startViewPager() {
        binding.vp2Scenario.adapter = ScenarioPageAdapter(scenarioList)
        binding.vp2Scenario.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.indicatorScenario.setViewPager(binding.vp2Scenario)
    }

    private fun resetLists() {
        this.scenarioList.clear()
        this.scenarioList = ScenarioFactory.getScenarios(numberOfScenarios)
    }
}