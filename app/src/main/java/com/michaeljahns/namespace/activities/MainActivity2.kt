package com.michaeljahns.namespace.activities

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
    private val forageFragment = ForageFragment()
    private val collectionFragment = CollectionFragment()

    private val model: UIViewModel by viewModels()
    private lateinit var scenarioModel: ScenarioModel

    lateinit var binding: ActivityMainBinding
    private lateinit var Fab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = InjectorUtils.provideScenarioModelFactory()
        scenarioModel = ViewModelProvider(this, factory)
                .get(ScenarioModel::class.java)
        binding = ActivityMainBinding.inflate(layoutInflater)
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.mainNavigationView, navigationFragment)
            commit()
        }
        Fab = binding.mainNavigationView.omnifab
        setCurrentFragment(scenarioFragment)
        model.setActiveViewString("Scenario")
        bindOmniFab()
        model.intView.observe(this, Observer {
            when (it) {
                R.id.miScenario -> {
                    setCurrentFragment(scenarioFragment)
                    model.setActiveViewString("Scenario")
                    Fab.imageTintList = ColorStateList.valueOf(Color.rgb(255, 153, 15))
                }
                R.id.miForage -> {
                    setCurrentFragment(forageFragment)
                    model.setActiveViewString("Forage")
                    Fab.imageTintList = ColorStateList.valueOf(Color.rgb(41, 197, 29))
                }
                R.id.miCollection -> {
                    setCurrentFragment(collectionFragment)
                    model.setActiveViewString("Collection")
                    Fab.imageTintList = ColorStateList.valueOf(Color.rgb(40, 44, 52))
                }
            }
            bindOmniFab()
        })
        val view = binding.root
        setContentView(view)
    }

    private fun bindOmniFab() {
        Fab.setOnClickListener {
            when (model.activeViewString.value) {
                "Scenario" -> {
                    scenarioModel.regenerateScenarios()
                    Log.d("MAIN", "Omnifab onclick to reset generated scenarios")
                }
                "Forage" -> {
                    Toast.makeText(this, "Future Feature, Regenerate Forages!", Toast.LENGTH_LONG).show()
//                    forageModel.regenerateScenarios()
                    Log.d("MAIN", "Omnifab onclick to reset generated Forages")
                }
                "Collection" -> {
                    Toast.makeText(this, "Future Feature, add to your collection!", Toast.LENGTH_LONG).show()
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


