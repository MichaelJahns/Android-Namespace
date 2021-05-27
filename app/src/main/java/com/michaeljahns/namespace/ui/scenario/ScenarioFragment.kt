package com.michaeljahns.namespace.ui.scenario

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
import com.michaeljahns.namespace.repository.scenario.Scenario
import com.michaeljahns.namespace.util.InjectorUtils
import com.michaeljahns.namespace.viewmodel.scenario.ScenarioViewModel
import com.michaeljahns.namespace.viewmodel.scenario.ScenarioViewModelFactory

class ScenarioFragment : Fragment(R.layout.fragment_scenario) {
    private lateinit var binding: FragmentScenarioBinding
    private val factoryView: ScenarioViewModelFactory = InjectorUtils.provideScenarioModelFactory()
    private lateinit var scenarioViewModel: ScenarioViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentScenarioBinding.inflate(layoutInflater, container, false)
        initUI()
        return binding.root
    }

    private fun initUI() {
        scenarioViewModel = ViewModelProvider(this, factoryView)
                .get(ScenarioViewModel::class.java)
        scenarioViewModel.getScenarios().observe(viewLifecycleOwner, Observer { scenarios ->
            startViewPager(scenarios)
        })
    }

    private fun startViewPager(scenarioList: List<Scenario>) {
        binding.vp2Scenario.adapter = ScenarioPageAdapter(scenarioList)
        binding.vp2Scenario.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.indicatorScenario.setViewPager(binding.vp2Scenario)
    }
}