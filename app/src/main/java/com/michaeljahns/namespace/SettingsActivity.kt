package com.michaeljahns.namespace

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.RangeSlider
import com.google.android.material.slider.Slider

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val btnSaveSettings = findViewById<Button>(R.id.btnSaveSettings)
        btnSaveSettings.setOnClickListener{
            saveData()
        }
        loadData()
    }
    private fun saveData() {
        val dsNumberOfScenarios = findViewById<Slider>(R.id.dsNumberOfScenarios)
        val rsAgeRangeOfPawns = findViewById<RangeSlider>(R.id.rsAgeRangeOfPawns)

        val sharedPreferences = getSharedPreferences("persistentSettings", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply{
            putInt("NumberOfScenarios", dsNumberOfScenarios.value.toInt())
            putInt("MinimumPawnAge", rsAgeRangeOfPawns.valueFrom.toInt())
            putInt("MaximumPawnAge", rsAgeRangeOfPawns.valueTo.toInt())
        }.apply()

        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT ).show()
    }
    private fun loadData(){
        val dsNumberOfScenarios = findViewById<Slider>(R.id.dsNumberOfScenarios)
        val rsAgeRangeOfPawns = findViewById<RangeSlider>(R.id.rsAgeRangeOfPawns)

        val sharedPreferences = getSharedPreferences("persistentSettings", Context.MODE_PRIVATE)
        val NumberOfScenarios = sharedPreferences.getInt("NumberOfScenarios", 15)
        val MinimumPawnAge = sharedPreferences.getInt("MinimumPawnAge", 13)
        val MaximumPawnAge = sharedPreferences.getInt("MaximumPawnAge", 70)

        dsNumberOfScenarios.value = NumberOfScenarios.toFloat()
        rsAgeRangeOfPawns.valueFrom = MinimumPawnAge.toFloat()
        rsAgeRangeOfPawns.valueTo = MaximumPawnAge.toFloat()

    }
}