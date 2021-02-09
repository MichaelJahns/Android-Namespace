package com.michaeljahns.namespace.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.michaeljahns.namespace.databinding.FragmentScenarioSettingsBinding
import com.michaeljahns.namespace.models.ScenarioModel


class ScenarioSettingsFragment : Fragment(){
    private lateinit var binding: FragmentScenarioSettingsBinding
    private val model: ScenarioModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentScenarioSettingsBinding.inflate(inflater, container, false)
        Log.d("SCENSETT", "Atttempting to create Fragment")


        val seekBar: SeekBar = binding.dsNumberOfScenarios
        seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                    Log.d("SCENSETT", "Progress Changed $progress")
                    onDSChange(progress)
                }
                override fun onStartTrackingTouch(seekBar: SeekBar) {
                }
                override fun onStopTrackingTouch(seekBar: SeekBar) {
                }
            })

        return binding.root
    }

    private fun onDSChange(number: Int){
        Log.d("SCENSETT", "Atttempted to update models DS $Int")
        model.setNumberOfScenarios(number)
    }



}