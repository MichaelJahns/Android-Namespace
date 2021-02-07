package com.michaeljahns.namespace.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.michaeljahns.namespace.CollectionFragment
import com.michaeljahns.namespace.R
import com.michaeljahns.namespace.UIViewModel
import com.michaeljahns.namespace.databinding.ActivityMainBinding
import com.michaeljahns.namespace.fragments.NavigationFragment
import com.michaeljahns.namespace.fragments.ScenarioFragment
import com.michaeljahns.namespace.fragments.SettingsFragment

class MainActivity2 : AppCompatActivity() {
    private val navigationFragment = NavigationFragment()
    private val scenarioFragment = ScenarioFragment()
    private val settingsFragment = SettingsFragment()
    private val collectionFragment = CollectionFragment()
    private val model: UIViewModel by viewModels()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.mainNavigationView, navigationFragment)
            commit()
        }

        setCurrentFragment(scenarioFragment)
        model.intView.observe(this, Observer {
            when (it) {
                R.id.miHome -> setCurrentFragment(scenarioFragment)
                R.id.miCollection -> setCurrentFragment(collectionFragment)
                R.id.miSettings -> setCurrentFragment(settingsFragment)
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


