package com.michaeljahns.namespace

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.michaeljahns.namespace.grammy.Location
import com.michaeljahns.namespace.grammy.LocationLayoutAdapter
import com.michaeljahns.namespace.grammy.Tracery
import java.util.*

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        val context = GlobalApplication.getAppContext()
        val JSON = readJsonFromAsset(context)
        var locations: List<Location> = flattenLocationsFromJson(JSON)
        startRecycler(locations, context)
    }


    fun flattenLocationsFromJson(JSON: String): List<Location> {
        val locations: MutableList<Location> = ArrayList()
        for (i in 1..15) {
            var locationName = Tracery.flattenJSON(JSON)
            val location = Location(locationName)
            locations.add(location)
        }
        return locations
    }

    fun readJsonFromAsset(context: Context): String? {
        var json: String? = null
        json = try {
            val inputStream = context.assets.open("pirateLocations.json")
            val buffer = ByteArray(inputStream.available())
            inputStream.read(buffer)
            inputStream.close()
            String(buffer)
        } catch (e: Exception) {
            Log.e("Error", e.message)
            return null
            return json
        }
        return null;
    }

    fun startRecycler(locations: List<Location?>?, context: Context?) {
        val locationLayoutAdapter = LocationLayoutAdapter(context, locations)
        this.locationRecycler.setAdapter(locationLayoutAdapter)
        this.locationRecycler.setLayoutManager(LinearLayoutManager(context))
    }
}