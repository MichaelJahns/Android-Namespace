package com.michaeljahns.namespace.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.michaeljahns.namespace.CollectionFragment
import com.michaeljahns.namespace.R
import com.michaeljahns.namespace.UIViewModel


class FrameLayout : Fragment() {
    private val scenarioFragment = ScenarioFragment()
    private val settingsFragment = SettingsFragment()
    private val collectionFragment = CollectionFragment()
    private val model: UIViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_frame_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setCurrentFragment(scenarioFragment)
        model.intView.observe(viewLifecycleOwner, Observer {
            when (it) {
                R.id.miHome -> setCurrentFragment(scenarioFragment)
                R.id.miCollection -> setCurrentFragment(collectionFragment)
                R.id.miSettings -> setCurrentFragment(settingsFragment)
            }
        })
    }

    private fun setCurrentFragment(fragment: Fragment) =
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.mainFrameLayout, fragment)
                commit()
            }

}