package com.michaeljahns.namespace

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.michaeljahns.namespace.grammy.Location
import me.relex.circleindicator.CircleIndicator3

class MainActivity2 : AppCompatActivity() {

    private var locationList = mutableListOf<Location>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Shuffled", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        val context = GlobalApplication.getAppContext()
        val JSON = readJsonFromAsset(context)
        flattenLocationsFromJson(JSON)
        startViewPager()
    }

    private fun flattenLocationsFromJson(JSON: String?) {
        for (i in 1..15) {
            var locationName = flattenJSON(JSON)
            val location = Location(locationName)
            this.locationList.add(location)
        }
    }

    private fun flattenJSON(Json: String?): String {
        val grammar = com.almasb.grammy.Grammy.createGrammar(Json)
        return grammar.flatten("origin")
    }

    private fun readJsonFromAsset(context: Context): String? {
        var json: String? = null
        val inputStream = context.assets.open("pirateLocations.json")
        val buffer = ByteArray(inputStream.available())
        inputStream.read(buffer)
        inputStream.close()
        json = String(buffer)
        return json
    }

    private fun startViewPager() {
        val scenario_pager2 = findViewById<ViewPager2>(R.id.scenario_pager2);
        val indicator = findViewById<CircleIndicator3>(R.id.indicator)

        scenario_pager2.adapter = ViewPageAdapter(locationList)
        scenario_pager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        indicator.setViewPager(scenario_pager2)
    }
}