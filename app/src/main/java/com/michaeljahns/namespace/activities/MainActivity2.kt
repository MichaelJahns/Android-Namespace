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
import com.michaeljahns.namespace.collection.CollectionFragment
import com.michaeljahns.namespace.databinding.ActivityMainBinding
import com.michaeljahns.namespace.forage.ForageFragment
import com.michaeljahns.namespace.forage.ForageModel
import com.michaeljahns.namespace.forage.ForageModelFactory
import com.michaeljahns.namespace.models.UIViewModel
import com.michaeljahns.namespace.pawn.PawnFragment
import com.michaeljahns.namespace.pawn.PawnModel
import com.michaeljahns.namespace.pawn.PawnModelFactory
import com.michaeljahns.namespace.scenario.ScenarioFragment
import com.michaeljahns.namespace.scenario.ScenarioModel
import com.michaeljahns.namespace.scenario.ScenarioModelFactory
import com.michaeljahns.namespace.util.InjectorUtils
import com.michaeljahns.namespace.util.NavigationFragment

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val pawnFactory: PawnModelFactory = InjectorUtils.providePawnModelFactory()
    private val scenarioFactory: ScenarioModelFactory = InjectorUtils.provideScenarioModelFactory()
    private val forageFactory: ForageModelFactory = InjectorUtils.provideForageModelFactory()

    private val navigationFragment = NavigationFragment()

    private val pawnFragment = PawnFragment()
    private val scenarioFragment = ScenarioFragment()
    private val forageFragment = ForageFragment()
    private val collectionFragment = CollectionFragment()

    private val uiModel: UIViewModel by viewModels()
    private lateinit var pawnModel: PawnModel
    private lateinit var scenarioModel: ScenarioModel
    private lateinit var forageModel: ForageModel

    private lateinit var Fab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        initUI()
        setContentView(binding.root)
    }

    private fun initUI() {
        scenarioModel = ViewModelProvider(this, scenarioFactory)
                .get(ScenarioModel::class.java)
        forageModel = ViewModelProvider(this, forageFactory)
                .get(ForageModel::class.java)
        pawnModel = ViewModelProvider(this, pawnFactory)
                .get(PawnModel::class.java)

        Fab = binding.mainNavigationView.fab
        
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.mainNavigationView, navigationFragment)
            commit()
        }

        setCurrentFragment(scenarioFragment)
        uiModel.setActiveViewString("Scenario")
        bindOmniFab()

        uiModel.intView.observe(this, Observer {
            when (it) {
                R.id.miPawn -> {
                    setCurrentFragment(pawnFragment)
                    uiModel.setActiveViewString("Pawn")
                    Fab.imageTintList = ColorStateList.valueOf(Color.rgb(30, 139, 195))
                }
                R.id.miScenario -> {
                    setCurrentFragment(scenarioFragment)
                    uiModel.setActiveViewString("Scenario")
                    Fab.imageTintList = ColorStateList.valueOf(Color.rgb(255, 153, 15))
                }
                R.id.miForage -> {
                    setCurrentFragment(forageFragment)
                    uiModel.setActiveViewString("Forage")
                    Fab.imageTintList = ColorStateList.valueOf(Color.rgb(41, 197, 29))
                }
                R.id.miCollection -> {
                    setCurrentFragment(collectionFragment)
                    uiModel.setActiveViewString("Collection")
                    Fab.imageTintList = ColorStateList.valueOf(Color.rgb(40, 44, 52))
                }
            }
            bindOmniFab()
        })
    }

    private fun bindOmniFab() {
        Fab.setOnClickListener {
            when (uiModel.activeViewString.value) {
                "Pawn" -> {
                    pawnModel.regeneratePawns()
                    Log.d("MAIN", "Omnifab onclick to reset generated pawns")
                }
                "Scenario" -> {
                    scenarioModel.regenerateScenarios()
                    Log.d("MAIN", "Omnifab onclick to reset generated scenarios")
                }
                "Forage" -> {
                    forageModel.regenerateForages()
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


