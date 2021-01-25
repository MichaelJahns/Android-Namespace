package com.michaeljahns.namespace

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.michaeljahns.namespace.grammy.CustomAdapter
import com.michaeljahns.namespace.grammy.Location
import java.util.*

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
        startRecycler(this.locationList)
    }

    
    fun flattenLocationsFromJson(JSON: String?) {
        for (i in 1..15) {
            var locationName = flattenJSON(JSON)
            val location = Location(locationName)
            this.locationList.add(location)
        }
    }

    fun flattenJSON(Json: String?): String {
        val grammar = com.almasb.grammy.Grammy.createGrammar(Json)
        return grammar.flatten("origin")
    }

    fun readJsonFromAsset(context: Context): String? {
        var json: String? = null
        val inputStream = context.assets.open("pirateLocations.json")
        val buffer = ByteArray(inputStream.available())
        inputStream.read(buffer)
        inputStream.close()
        json = String(buffer)
        return json
    }


    fun startRecycler(locations: List<Location?>?) {
        val recyclerView = findViewById(R.id.locationRecycler) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val adapter = CustomAdapter(locations)
        recyclerView.adapter = adapter
    }
}