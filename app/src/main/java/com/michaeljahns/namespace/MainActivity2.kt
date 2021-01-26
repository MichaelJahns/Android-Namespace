package com.michaeljahns.namespace

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.michaeljahns.namespace.grammy.Location
import com.michaeljahns.namespace.grammy.Pawn
import me.relex.circleindicator.CircleIndicator3
import kotlin.random.Random

class MainActivity2 : AppCompatActivity() {

    private var locationList = mutableListOf<Location>()
    private var pawnList = mutableListOf<Pawn>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val context = GlobalApplication.getAppContext()

        bindViews(context)
        flattenScenarioFromGrammy(context)
        startViewPager()
    }

    private fun bindViews(context: Context) {
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Shuffled", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            resetLists()
            flattenScenarioFromGrammy(context)
            startViewPager()
        }
    }

    private fun flattenScenarioFromGrammy(context: Context) {
        val locationJson = readJsonFromAsset(context, "pirateLocations.json")
        flattenLocationsFromJson(locationJson)
        val pawnJson = readJsonFromAsset(context, "pirateNames.json")
        flattenPawnFromJson(pawnJson)
    }

    private fun flattenLocationsFromJson(JSON: String?) {
        for (i in 1..15) {
            var locationName = flattenJsonOnKey(JSON, "origin")
            val location = Location(locationName)
            this.locationList.add(location)
        }
    }

    private fun flattenPawnFromJson(JSON: String?) {
        for (i in 1..15) {
            var pawnName = flattenJsonOnKey(JSON, "name")
            val minAge = 13
            val maxAge = 69
            var pawnAge = rand(minAge, maxAge)
            var pawnProfession = flattenJsonOnKey(JSON, "profession")
            val pawn = Pawn(pawnName, pawnAge, pawnProfession)
            this.pawnList.add(pawn)
        }
    }

    private fun flattenJsonOnKey(Json: String?, key: String): String {
        val grammar = com.almasb.grammy.Grammy.createGrammar(Json)
        return grammar.flatten(key)
    }

    private fun resetLists() {
        this.locationList.clear()
        this.pawnList.clear()
    }

    fun rand(start: Int, end: Int): Int {
        require(start <= end) { "Illegal Argument" }
        val rand = Random(System.nanoTime())
        return (start..end).random(rand)
    }

    private fun readJsonFromAsset(context: Context, assetName: String): String? {
        var json: String? = null
        val inputStream = context.assets.open(assetName)
        val buffer = ByteArray(inputStream.available())
        inputStream.read(buffer)
        inputStream.close()
        json = String(buffer)
        return json
    }

    private fun startViewPager() {
        val scenario_pager2 = findViewById<ViewPager2>(R.id.scenario_pager2);
        val indicator = findViewById<CircleIndicator3>(R.id.indicator)

        scenario_pager2.adapter = ViewPageAdapter(locationList, pawnList)
        scenario_pager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        indicator.setViewPager(scenario_pager2)
    }
}