package com.michaeljahns.namespace.ui.forage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.michaeljahns.namespace.R
import com.michaeljahns.namespace.repository.forage.Forage

class ForagePageAdapter(private var forages: List<Forage>) : RecyclerView.Adapter<ForagePageAdapter.ViewPager2Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPager2Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.forage_page, parent, false)
        return ViewPager2Holder(view)
    }

    override fun onBindViewHolder(holder: ViewPager2Holder, position: Int) {
        val forage: Forage = forages[position]
        holder.forageLandmark.text = forage.landmark
        holder.forageDescription.text = forage.description
    }

    override fun getItemCount(): Int {
        return forages.size
    }

    inner class ViewPager2Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val forageLandmark: TextView = itemView.findViewById(R.id.tvLandmarkForage)
        val forageDescription: TextView = itemView.findViewById(R.id.tvDescriptionForage)
    }
}
