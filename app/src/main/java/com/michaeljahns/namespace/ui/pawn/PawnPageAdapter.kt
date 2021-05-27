package com.michaeljahns.namespace.ui.pawn

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.michaeljahns.namespace.R
import com.michaeljahns.namespace.repository.pawn.Pawn

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

        // Skills
        holder.pawnStrength.text = pawn.statBlock!!.strength.toString()
        holder.pawnEndurance.text = pawn.statBlock.endurance.toString()
        holder.pawnDexterity.text = pawn.statBlock.dexterity.toString()
        holder.pawnIntelligence.text = pawn.statBlock.intelligence.toString()
        holder.pawnMentality.text = pawn.statBlock.mentality.toString()
        holder.pawnCharisma.text = pawn.statBlock.charisma.toString()

    }

    override fun getItemCount(): Int {
        return pawns.size
    }

    inner class ViewPager2Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pawnName: TextView = itemView.findViewById(R.id.tvPawnName)
        val pawnAge: TextView = itemView.findViewById(R.id.tvPawnAge)
        val pawnProfession: TextView = itemView.findViewById(R.id.tvPawnProfession)

        // Skills
        val pawnStrength: TextView = itemView.findViewById(R.id.etvPawnStrength)
        val pawnEndurance: TextView = itemView.findViewById(R.id.etvPawnEndurance)
        val pawnDexterity: TextView = itemView.findViewById(R.id.etvPawnDexterity)
        val pawnIntelligence: TextView = itemView.findViewById(R.id.etvPawnIntelligence)
        val pawnMentality: TextView = itemView.findViewById(R.id.etvPawnMentality)
        val pawnCharisma: TextView = itemView.findViewById(R.id.etvPawnCharisma)
    }


}