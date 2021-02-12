package com.michaeljahns.namespace.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.michaeljahns.namespace.R
import com.michaeljahns.namespace.databinding.ActivityMainBinding
import com.michaeljahns.namespace.fragments.CollectionFragment
import com.michaeljahns.namespace.fragments.ForageFragment
import com.michaeljahns.namespace.fragments.NavigationFragment
import com.michaeljahns.namespace.fragments.ScenarioFragment
import com.michaeljahns.namespace.models.ScenarioModel
import com.michaeljahns.namespace.models.UIViewModel

class MainActivity2 : AppCompatActivity() {
    private val navigationFragment = NavigationFragment()
    private val scenarioFragment = ScenarioFragment()

    //    private val settingsFragment = SettingsFragment()
    private val forageFragment = ForageFragment()
    private val collectionFragment = CollectionFragment()
    private val model: UIViewModel by viewModels()
    private val scenarioModel: ScenarioModel by viewModels()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.mainNavigationView, navigationFragment)
            commit()
        }

        binding.mainNavigationView.omnifab.setOnClickListener {
            val customToad = Toast.makeText(this, "Re-roll! Someday", Toast.LENGTH_SHORT)
            scenarioModel.regenerateScenarios()
            customToad.show()
        }

        setCurrentFragment(scenarioFragment)
        model.intView.observe(this, Observer {
            when (it) {
                R.id.miScenario -> {
                    setCurrentFragment(scenarioFragment)
                }
                R.id.miCollection -> setCurrentFragment(collectionFragment)
//                R.id.miSettings -> setCurrentFragment(settingsFragment)
                R.id.miForage -> setCurrentFragment(forageFragment)
            }
        })

        val view = binding.root
        setContentView(view)
    }

    private fun setCurrentFragment(fragment: Fragment) =
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.mainFrameLayout, fragment)
                commit()
            }
}


