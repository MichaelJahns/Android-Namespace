package com.michaeljahns.namespace.pawn

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.michaeljahns.namespace.R

class PawnPageAdapter(private var pawns: List<Pawn>) : RecyclerView.Adapter<PawnPageAdapter.ViewPager2Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPager2Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.pawn_page, parent, false)
        return ViewPager2Holder(view)
    }

    override fun onBindViewHolder(holder: ViewPager2Holder, position: Int) {
        val pawn = pawns[position]
        holder.pawnName.text = pawn.name
        holder.pawnAge.text = pawn.age.toString()
        holder.pawnProfession.text = pawn.profession
    }

    override fun getItemCount(): Int {
        return pawns.size
    }

    inner class ViewPager2Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pawnName: TextView = itemView.findViewById(R.id.tvPawnName)
        val pawnAge: TextView = itemView.findViewById(R.id.tvPawnAge)
        val pawnProfession: TextView = itemView.findViewById(R.id.tvPawnProfession)
    }


}