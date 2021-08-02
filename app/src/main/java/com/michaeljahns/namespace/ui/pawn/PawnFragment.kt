package com.michaeljahns.namespace.ui.pawn

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.michaeljahns.namespace.R
import com.michaeljahns.namespace.databinding.FragmentPawnBinding
import com.michaeljahns.namespace.repository.pawn.Pawn
import com.michaeljahns.namespace.util.InjectorUtils
import com.michaeljahns.namespace.viewmodel.pawn.PawnViewModel
import com.michaeljahns.namespace.viewmodel.pawn.PawnViewModelFactory

class PawnFragment
    : Fragment(R.layout.fragment_pawn),
        PawnPageAdapter.OnPawnClickedListener {
    private lateinit var binding: FragmentPawnBinding
    private val factoryView: PawnViewModelFactory = InjectorUtils.providePawnModelFactory()
    private lateinit var pawnViewModel: PawnViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentPawnBinding.inflate(layoutInflater, container, false)
        initUI()
        return binding.root
    }

    private fun initUI() {
        pawnViewModel = ViewModelProvider(this, factoryView)
                .get(PawnViewModel::class.java)
        pawnViewModel.getPawns().observe(viewLifecycleOwner, Observer { pawns ->
            startViewPager(pawns)
        })
    }

    private fun startViewPager(pawnList: List<Pawn>) {
        binding.vp2Pawn.adapter = PawnPageAdapter(pawnList, this)
        binding.vp2Pawn.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.indicatorPawn?.setViewPager(binding.vp2Pawn)
    }
    
    override fun onPawnClicked(pawn: Pawn, position: Int) {
        Log.d("Pawn Fragment", "A pawn was clicked")
        Toast.makeText(context, pawn.name + " , " + pawn.profession, Toast.LENGTH_LONG).show()
    }
}