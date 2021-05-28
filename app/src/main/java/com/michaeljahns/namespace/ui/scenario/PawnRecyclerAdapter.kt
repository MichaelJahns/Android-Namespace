package com.michaeljahns.namespace.ui.scenario

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.michaeljahns.namespace.R
import com.michaeljahns.namespace.repository.pawn.Pawn

class PawnRecyclerAdapter(
        private val pawnClickedListener: OnPawnSaveListener,
        private var pawns: List<Pawn>
) : RecyclerView.Adapter<PawnRecyclerAdapter.PawnViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PawnViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.pawn_row, parent, false)
        return PawnViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PawnViewHolder, position: Int) {
        holder.pawnName.text = """${pawns[position].name},"""
        holder.pawnProfession.text = pawns[position].profession
        holder.pawnAge.text = pawns[position].age.toString()
    }

    override fun getItemCount(): Int {
        return pawns.size
    }

    inner class PawnViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView),
            View.OnClickListener {
        val pawnName: TextView = itemView.findViewById(R.id.tvPawnName)
        val pawnProfession: TextView = itemView.findViewById(R.id.tvPawnProfession)
        val pawnAge: TextView = itemView.findViewById(R.id.tvPawnAge)
        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                pawnClickedListener.onPawnSaved(pawns[position])
            }
        }
    }

    interface OnPawnSaveListener {
        fun onPawnSaved(pawn: Pawn)
    }
}