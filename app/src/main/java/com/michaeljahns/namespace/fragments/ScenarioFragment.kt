package com.michaeljahns.namespace.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.michaeljahns.namespace.R
import com.michaeljahns.namespace.databinding.FragmentScenarioBinding
import com.michaeljahns.namespace.models.ScenarioModel
import com.michaeljahns.namespace.scenario.Scenario
import com.michaeljahns.namespace.scenario.ScenarioModelFactory
import com.michaeljahns.namespace.scenario.ScenarioPageAdapter
import com.michaeljahns.namespace.util.InjectorUtils

class ScenarioFragment : Fragment(R.layout.fragment_scenario) {
    private lateinit var binding: FragmentScenarioBinding
    private val factory: ScenarioModelFactory = InjectorUtils.provideScenarioModelFactory()
    private lateinit var viewModel: ScenarioModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentScenarioBinding.inflate(layoutInflater, container, false)
        initUI()
        return binding.root
    }

    private fun initUI() {
        viewModel = ViewModelProvider(this, factory)
                .get(ScenarioModel::class.java)
        viewModel.getScenarios().observe(viewLifecycleOwner, Observer { scenarios ->
            startViewPager(scenarios)
        })
    }

    private fun startViewPager(scenarioList: List<Scenario>) {
        binding.vp2Scenario.adapter = ScenarioPageAdapter(scenarioList)
        binding.vp2Scenario.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.indicatorScenario.setViewPager(binding.vp2Scenario)
    }
}