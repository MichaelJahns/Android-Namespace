package com.michaeljahns.namespace.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.michaeljahns.namespace.R
import com.michaeljahns.namespace.databinding.ActivityMainBinding
import com.michaeljahns.namespace.fragments.CollectionFragment
import com.michaeljahns.namespace.fragments.ForageFragment
import com.michaeljahns.namespace.fragments.NavigationFragment
import com.michaeljahns.namespace.fragments.ScenarioFragment
import com.michaeljahns.namespace.models.ScenarioModel
import com.michaeljahns.namespace.models.UIViewModel
import com.michaeljahns.namespace.util.InjectorUtils

class MainActivity2 : AppCompatActivity() {
    private val navigationFragment = NavigationFragment()
    private val scenarioFragment = ScenarioFragment()

    //    private val settingsFragment = SettingsFragment()
    private val forageFragment = ForageFragment()
    private val collectionFragment = CollectionFragment()
    private val model: UIViewModel by viewModels()
    private lateinit var viewModel: ScenarioModel
    private lateinit var omniFab: FloatingActionButton
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = InjectorUtils.provideScenarioModelFactory()
        viewModel = ViewModelProvider(this, factory)
                .get(ScenarioModel::class.java)
        binding = ActivityMainBinding.inflate(layoutInflater)
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.mainNavigationView, navigationFragment)
            commit()
        }
        omniFab = binding.mainNavigationView.omnifab
        setCurrentFragment(scenarioFragment)
        model.setActiveViewString("Scenario")
        bindOmniFab()
        model.intView.observe(this, Observer {
            when (it) {
                R.id.miScenario -> {
                    setCurrentFragment(scenarioFragment)
                    model.setActiveViewString("Scenario")
//                    namespaceOrange
                }
                R.id.miForage -> {
                    setCurrentFragment(forageFragment)
                    model.setActiveViewString("Forage")
//                    forageGreen
                }
                R.id.miCollection -> {
                    setCurrentFragment(collectionFragment)
                    model.setActiveViewString("Collection")
                }

            }
            bindOmniFab()
        })
        val view = binding.root
        setContentView(view)
    }

    private fun bindOmniFab() {
        omniFab.setOnClickListener {
            when (model.activeViewString.value) {
                "Scenario" -> {
                    viewModel.regenerateScenarios()
                    Log.d("MAIN", "Omnifab onclick to reset generated scenarios")

                }
                "Forage" -> {

                    Log.d("MAIN", "Omnifab onclick to reset generated Forages")
                }
                "Collection" -> {
                    
                    Log.d("MAIN", "Omnifab onclick to appropriate collection action")
                }
            }
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.mainFrameLayout, fragment)
                commit()
            }


}


