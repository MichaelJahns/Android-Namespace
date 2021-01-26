package com.michaeljahns.namespace

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.michaeljahns.namespace.grammy.Location

class ViewPageAdapter(private var location: List<Location>) : RecyclerView.Adapter<ViewPageAdapter.ViewPager2Holder>() {

    inner class ViewPager2Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val scenarioLocation: TextView = itemView.findViewById(R.id.locationName)

        init {
            scenarioLocation.setOnClickListener { v: View ->
                val position = adapterPosition
                Toast.makeText(itemView.context, "$position " + scenarioLocation.text, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPageAdapter.ViewPager2Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.location_row, parent, false)
        view.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        return ViewPager2Holder(view)
    }

    override fun onBindViewHolder(holder: ViewPageAdapter.ViewPager2Holder, position: Int) {
        holder.scenarioLocation.text = location[position].toString()
    }

    override fun getItemCount(): Int {
        return location.size
    }
}