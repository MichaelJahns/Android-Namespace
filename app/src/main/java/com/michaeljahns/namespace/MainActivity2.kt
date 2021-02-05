package com.michaeljahns.namespace

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.michaeljahns.namespace.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context = GlobalApplication.getAppContext()

        val scenarioFragment = ScenarioFragment()
        val settingsFragment = SettingsFragment()
        val collectionFragment = CollectionFragment()
        setCurrentFragment(scenarioFragment)
        bindViews(context)
        startMainNavigationBar()

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.mainNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.miHome -> setCurrentFragment(scenarioFragment)
                R.id.miCollection -> setCurrentFragment(collectionFragment)
                R.id.miSettings -> setCurrentFragment(settingsFragment)
            }
            true
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.mainNavigationView)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun setCurrentFragment(fragment: Fragment) =
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.mainFrameLayout, fragment)
                commit()
            }

    private fun bindViews(context: Context) {
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            Toast.makeText(context, "Fab Disconnected", Toast.LENGTH_SHORT).show()
        }
    }

    private fun startMainNavigationBar() {
        val mainNavigationView = findViewById<BottomNavigationView>(R.id.mainNavigationView)
        mainNavigationView.background = null
        mainNavigationView.menu.getItem(2).isEnabled = false
    }
}