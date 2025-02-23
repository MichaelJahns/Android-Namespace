package com.michaeljahns.namespace.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.michaeljahns.namespace.R
import com.michaeljahns.namespace.databinding.FragmentNavigationBinding
import com.michaeljahns.namespace.viewmodel.UIViewModel

class NavigationFragment : Fragment(R.layout.fragment_navigation) {
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var binding: FragmentNavigationBinding
    private val model: UIViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentNavigationBinding.inflate(inflater, container, false)
        bottomNavigationView = binding.bottomNavigationView
        bottomNavigationView.background = null
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomNavigationView.menu.getItem(2).isEnabled = false
        bottomNavigationView.setOnNavigationItemSelectedListener {
            model.select(it.itemId)
            true
        }
    }
}