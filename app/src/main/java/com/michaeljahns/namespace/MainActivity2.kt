package com.michaeljahns.namespace

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.michaeljahns.namespace.grammy.Location
import com.michaeljahns.namespace.grammy.Pawn
import com.michaeljahns.namespace.grammy.Scenario
import me.relex.circleindicator.CircleIndicator3
import kotlin.random.Random

class MainActivity2 : AppCompatActivity() {

    private var scenarioList = mutableListOf<Scenario>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val context = GlobalApplication.getAppContext()

        bindViews(context)
        flattenScenariosFromGrammy(context)
        startViewPager()
    }

    private fun bindViews(context: Context) {
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            Toast.makeText(context, "Shuffled", Toast.LENGTH_SHORT).show()
            resetLists()
            flattenScenariosFromGrammy(context)
            startViewPager()
        }
    }

    private fun flattenScenariosFromGrammy(context: Context) {
        val locationJson = readJsonFromAsset(context, "pirateLocations.json")
        val pawnJson = readJsonFromAsset(context, "pirateNames.json")
        for (i in 1..15) {
            val scenarioLocation = flattenLocationsFromJson(locationJson)
            val scenarioPawnList = mutableListOf<Pawn>()
            for (j in 1..generateCrewSize()) {
                val scenarioPawn = flattenPawnFromJson(pawnJson)
                scenarioPawnList.add(scenarioPawn)
            }
            val scenario = Scenario(scenarioLocation, scenarioPawnList)
            this.scenarioList.add(scenario)
        }
    }

    private fun flattenLocationsFromJson(JSON: String?): Location {
        val locationName = flattenJsonOnKey(JSON, "origin")
        return Location(locationName)
    }

    private fun flattenPawnFromJson(JSON: String?): Pawn {
        val pawnName = flattenJsonOnKey(JSON, "name")
        val pawnAge = generateAge()
        val pawnProfession = flattenJsonOnKey(JSON, "profession")
        return Pawn(pawnName, pawnAge, pawnProfession)
    }

    private fun generateAge(): Int {
        val minAge = 13
        val maxAge = 69
        return rand(minAge, maxAge)
    }

    private fun generateCrewSize(): Int {
        val minCrewSize = 1
        val maxCrewSize = 5
        return rand(minCrewSize, maxCrewSize)
    }

    private fun flattenJsonOnKey(Json: String?, key: String): String {
        val grammar = com.almasb.grammy.Grammy.createGrammar(Json)
        return grammar.flatten(key)
    }

    private fun resetLists() {
        this.scenarioList.clear()
    }

    private fun rand(start: Int, end: Int): Int {
        require(start <= end) { "Illegal Argument" }
        val rand = Random(System.nanoTime())
        return (start..end).random(rand)
    }

    private fun readJsonFromAsset(context: Context, assetName: String): String {
        val inputStream = context.assets.open(assetName)
        val buffer = ByteArray(inputStream.available())
        inputStream.read(buffer)
        inputStream.close()
        return String(buffer)
    }

    private fun startViewPager() {
        val scenarioPager2 = findViewById<ViewPager2>(R.id.scenario_pager2);
        val indicator = findViewById<CircleIndicator3>(R.id.indicator)

        scenarioPager2.adapter = ViewPageAdapter(scenarioList)
        scenarioPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        indicator.setViewPager(scenarioPager2)
    }
}