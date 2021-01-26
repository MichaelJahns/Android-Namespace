package com.michaeljahns.namespace.grammy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.michaeljahns.namespace.R

class CustomAdapter(val locationList: List<Location?>?) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.location_row, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        locationList?.get(position)?.let { holder.bindItems(it) }
    }

    override fun getItemCount(): Int {
        if (locationList != null) {
            return locationList.size
        }
        return 0;
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(location: Location) {
            val textViewName = itemView.findViewById(R.id.locationName) as TextView
            textViewName.text = location.name;
        }
    }
}