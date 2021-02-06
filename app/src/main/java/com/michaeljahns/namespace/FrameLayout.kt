package com.michaeljahns.namespace

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class FrameLayout : Fragment() {

    private val scenarioFragment = ScenarioFragment()
    private val settingsFragment = SettingsFragment()
    private val collectionFragment = CollectionFragment()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        setCurrentFragment(scenarioFragment)
        return inflater.inflate(R.layout.fragment_frame_layout, container, false)
    }

    private fun setCurrentFragment(fragment: Fragment) =
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.mainFrameLayout, fragment)
                commit()
            }

    fun handleBoil(int: Int) {
        Log.d("FL:", "attempting to handleBoil")
        when (int) {
            R.id.miHome -> setCurrentFragment(scenarioFragment)
            R.id.miCollection -> setCurrentFragment(collectionFragment)
            R.id.miSettings -> setCurrentFragment(settingsFragment)
        }
    }
}