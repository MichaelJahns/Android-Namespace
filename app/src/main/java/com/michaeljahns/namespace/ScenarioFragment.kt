package com.michaeljahns.namespace

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.michaeljahns.namespace.databinding.FragmentScenarioBinding
import com.michaeljahns.namespace.grammy.Scenario

class ScenarioFragment : Fragment(R.layout.fragment_scenario) {
    private lateinit var binding: FragmentScenarioBinding
    private var scenarioList = mutableListOf<Scenario>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.scenarioList = ScenarioFactory.getScenarios(20)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentScenarioBinding.inflate(layoutInflater, container, false)
        startViewPager()
        return binding.root
    }

    private fun startViewPager() {
        binding.tvScenario.text = scenarioList[0].location.toString()
        binding.vp2Scenario.adapter = ScenarioPageAdapter(scenarioList)
        binding.vp2Scenario.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.indicatorScenario.setViewPager(binding.vp2Scenario)
    }

    private fun resetLists() {
        this.scenarioList.clear()
        this.scenarioList = ScenarioFactory.getScenarios(20)
    }
}