package com.michaeljahns.namespace.pawn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.michaeljahns.namespace.R
import com.michaeljahns.namespace.databinding.FragmentPawnBinding
import com.michaeljahns.namespace.util.InjectorUtils

class PawnFragment : Fragment(R.layout.fragment_pawn) {
    private lateinit var binding: FragmentPawnBinding
    private val factory: PawnModelFactory = InjectorUtils.providePawnModelFactory()
    private lateinit var pawnModel: PawnModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentPawnBinding.inflate(layoutInflater, container, false)
        initUI()
        return binding.root
    }

    private fun initUI() {
        pawnModel = ViewModelProvider(this, factory)
                .get(PawnModel::class.java)
        pawnModel.getPawns().observe(viewLifecycleOwner, Observer { pawns ->
            startViewPager(pawns)
        })
    }
    private fun startViewPager (pawnList: List<Pawn>){
        binding.vp2Pawn.adapter = PawnPageAdapter(pawnList)
        binding.vp2Pawn.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.indicatorPawn.setViewPager(binding.vp2Pawn)
    }
}