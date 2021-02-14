package com.michaeljahns.namespace.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.PopupWindow
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.michaeljahns.namespace.R
import com.michaeljahns.namespace.ScenarioPageAdapter
import com.michaeljahns.namespace.databinding.FragmentScenarioBinding
import com.michaeljahns.namespace.grammy.Scenario
import com.michaeljahns.namespace.models.ScenarioModel
import com.michaeljahns.namespace.util.InjectorUtils

class ScenarioFragment : Fragment(R.layout.fragment_scenario) {
    private val TAG = "SCEN"
    private lateinit var binding: FragmentScenarioBinding
    private lateinit var scenarioList: MutableLiveData<MutableList<Scenario>>
    private lateinit var settingsWindow: PopupWindow
    private var settingFragment = ScenarioSettingsFragment()
    private val model: ScenarioModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentScenarioBinding.inflate(layoutInflater, container, false)
        initUI()

        val settings = View.inflate(context, R.layout.fragment_scenario_settings, container)
        settingsWindow = PopupWindow(settings, FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT)
        settingsWindow.contentView = view
        showSettingsVisibility()

        binding.btnScenarioSettings.setOnClickListener {
            Log.d(TAG, "Btn Clicked")
            model.toggleSettingsVisibility()
        }

        model.isSettingsVisible.observe(viewLifecycleOwner, Observer {
            when (it) {
                true -> showSettingsVisibility()
                false -> hideSettingsVisibility()
            }
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model.numberOfScenarios.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "Entered")
            val customToad = Toast.makeText(context, "Observed a Re-roll", Toast.LENGTH_SHORT).show()
            regenerateLists()
        })
    }

    private fun regenerateLists() {
        scenarioList.value?.clear()
        scenarioList = model.scenarios
        Toast.makeText(context, "Experience Reroll", Toast.LENGTH_SHORT).show()
    }


    private fun initUI() {
        val factory = InjectorUtils.provideScenarioModelFactory()
        val viewModel = ViewModelProvider(this, factory)
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

    private fun showSettingsVisibility() {
        Log.d(TAG, "Attempting show of setting Popup.window")
        Toast.makeText(context, "Attempting ton show PopupWindow", Toast.LENGTH_SHORT).show()
        settingsWindow.showAsDropDown(binding.btnScenarioSettings)
    }

    private fun hideSettingsVisibility() {
        settingsWindow.dismiss()
    }
}