package com.michaeljahns.namespace.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.michaeljahns.namespace.databinding.FragmentNavigationBinding
import com.michaeljahns.namespace.models.UIViewModel

class NavigationFragment : Fragment() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var binding: FragmentNavigationBinding
    private val uIViewModel: UIViewModel by activityViewModels()

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
            uIViewModel.select(it.itemId)
            true
        }
    }
}