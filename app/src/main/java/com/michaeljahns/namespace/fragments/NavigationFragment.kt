package com.michaeljahns.namespace.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.michaeljahns.namespace.UIViewModel
import com.michaeljahns.namespace.databinding.FragmentNavigationBinding

class NavigationFragment : Fragment() {
    private lateinit var binding: FragmentNavigationBinding
    private val UIViewModel: UIViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentNavigationBinding.inflate(inflater, container, false)
        Log.d("TFF", "Echoes But Alone")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("TFF", "Echoes But Alone")
        super.onViewCreated(view, savedInstanceState)
        val nav = binding.mainNavigationView
        nav.background = null
        nav.menu.getItem(2).isEnabled = false
        nav.setOnNavigationItemSelectedListener {
            UIViewModel.select(it.itemId)
            true
        }
    }
}