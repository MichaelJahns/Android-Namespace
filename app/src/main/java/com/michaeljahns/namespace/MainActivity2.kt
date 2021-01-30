package com.michaeljahns.namespace

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.michaeljahns.namespace.grammy.Scenario
import me.relex.circleindicator.CircleIndicator3

class MainActivity2 : AppCompatActivity() {

    private var scenarioList = mutableListOf<Scenario>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context = GlobalApplication.getAppContext()
        scenarioList = ScenarioFactory.getScenarios(15)

        bindViews(context)
        startMainNavigationBar()
        startViewPager()
    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.mainNavHost)
//        return navController.navigateUp() || super.onSupportNavigateUp()
//    }

    private fun bindViews(context: Context) {
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            Toast.makeText(context, "Re-Rolled All Scenarios", Toast.LENGTH_SHORT).show()
            resetLists()
            startViewPager()
        }
    }

    private fun resetLists() {
        this.scenarioList.clear()
        this.scenarioList = ScenarioFactory.getScenarios(20)
    }

    private fun startViewPager() {
        val scenarioPager2 = findViewById<ViewPager2>(R.id.scenario_pager2);
        val indicator = findViewById<CircleIndicator3>(R.id.indicator)

        scenarioPager2.adapter = ScenarioPageAdapter(scenarioList)
        scenarioPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        indicator.setViewPager(scenarioPager2)
    }

    private fun startMainNavigationBar() {
        val mainNavigationView = findViewById<BottomNavigationView>(R.id.mainNavigationView)
        mainNavigationView.background = null
        mainNavigationView.menu.getItem(2).isEnabled = false
    }
}