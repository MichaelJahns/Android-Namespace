package com.michaeljahns.namespace

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.michaeljahns.namespace.databinding.FragmentNavbarBinding

class NavbarFragment : Fragment() {
    private lateinit var binding: FragmentNavbarBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentNavbarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nav = binding.mainNavigationView
        nav.background = null
        nav.menu.getItem(2).isEnabled = false
        nav.setOnNavigationItemSelectedListener {
            frameLayout.handleBoil(it.itemId)
            true
        }
    }
}