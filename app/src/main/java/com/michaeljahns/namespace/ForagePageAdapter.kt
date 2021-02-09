package com.michaeljahns.namespace

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.michaeljahns.namespace.grammy.Forage

class ForagePageAdapter(private var forageList: MutableLiveData<MutableList<Forage>>) : RecyclerView.Adapter<ForagePageAdapter.ViewPager2Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForagePageAdapter.ViewPager2Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.forage_page, parent, false)
        return ViewPager2Holder(view)
    }

    override fun onBindViewHolder(holder: ForagePageAdapter.ViewPager2Holder, position: Int) {
        val forage: Forage = forageList.value!![position]
        holder.forageLocation.text = forage.location.toString()
    }

    override fun getItemCount(): Int {
        return forageList.value?.size ?: 1
    }

    inner class ViewPager2Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val forageLocation: TextView = itemView.findViewById(R.id.forageLocation)
    }
}
