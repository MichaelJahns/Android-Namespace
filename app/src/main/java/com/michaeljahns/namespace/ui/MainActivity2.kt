package com.michaeljahns.namespace.ui

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
import com.michaeljahns.namespace.ui.forage.ForageFragment
import com.michaeljahns.namespace.ui.pawn.PawnFragment
import com.michaeljahns.namespace.ui.scenario.ScenarioFragment
import com.michaeljahns.namespace.util.InjectorUtils
import com.michaeljahns.namespace.viewmodel.UIViewModel
import com.michaeljahns.namespace.viewmodel.forage.ForageViewModel
import com.michaeljahns.namespace.viewmodel.forage.ForageViewModelFactory
import com.michaeljahns.namespace.viewmodel.pawn.PawnViewModel
import com.michaeljahns.namespace.viewmodel.pawn.PawnViewModelFactory
import com.michaeljahns.namespace.viewmodel.scenario.ScenarioViewModel
import com.michaeljahns.namespace.viewmodel.scenario.ScenarioViewModelFactory

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding


    private val scenarioViewFactory: ScenarioViewModelFactory = InjectorUtils.provideScenarioModelFactory()
    private val forageViewFactory: ForageViewModelFactory = InjectorUtils.provideForageModelFactory()

    private val navigationFragment = NavigationFragment()

    private val scenarioFragment = ScenarioFragment()
    private val forageFragment = ForageFragment()
    private val collectionFragment = CollectionFragment()

    private val uiModel: UIViewModel by viewModels()
    private lateinit var scenarioViewModel: ScenarioViewModel
    private lateinit var forageViewModel: ForageViewModel

    private lateinit var Fab: FloatingActionButton

    //    Pawn
    private lateinit var pawnFragment: PawnFragment
    private lateinit var pawnViewModel: PawnViewModel
    private lateinit var pawnViewFactory: PawnViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        initUI()
        setContentView(binding.root)

        pawnViewFactory = PawnViewModelFactory(
                this.application
        )
        pawnViewModel = ViewModelProvider(this, pawnViewFactory).get(PawnViewModel::class.java)
        pawnFragment = PawnFragment(pawnViewModel)
    }

    private fun initUI() {
        scenarioViewModel = ViewModelProvider(this, scenarioViewFactory)
                .get(ScenarioViewModel::class.java)
        forageViewModel = ViewModelProvider(this, forageViewFactory)
                .get(ForageViewModel::class.java)

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
                    pawnViewModel.generatePawns()
                    Log.d("MAIN", "Omnifab onclick to reset generated pawns")
                }
                "Scenario" -> {
                    scenarioViewModel.regenerateScenarios()
                    Log.d("MAIN", "Omnifab onclick to reset generated scenarios")
                }
                "Forage" -> {
                    forageViewModel.regenerateForages()
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


