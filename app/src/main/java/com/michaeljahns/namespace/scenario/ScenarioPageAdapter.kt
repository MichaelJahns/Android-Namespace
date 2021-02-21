package com.michaeljahns.namespace.scenario

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.michaeljahns.namespace.R

class ScenarioPageAdapter(private var scenarios: List<Scenario>) : RecyclerView.Adapter<ScenarioPageAdapter.ViewPager2Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPager2Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.scenario_page, parent, false)
//        Explicating declaring the below resolved some issue, i cant remember now which
//        view.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        return ViewPager2Holder(view)
    }

    override fun onBindViewHolder(holder: ViewPager2Holder, position: Int) {
        val scenario = scenarios[position]
        holder.scenarioLocation.text = scenario.location.toString()
        val childLayoutManager = LinearLayoutManager(holder.scenarioPawnRecycler.context, RecyclerView.VERTICAL, false)
        holder.scenarioPawnRecycler.layoutManager = childLayoutManager
        holder.scenarioPawnRecycler.adapter = PawnRecyclerAdapter(scenario.pawns)
    }

    override fun getItemCount(): Int {
        return scenarios.size
    }

    inner class ViewPager2Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val scenarioLocation: TextView = itemView.findViewById(R.id.locationName)
        val scenarioPawnRecycler: RecyclerView = itemView.findViewById(R.id.rvScenarioPawns)

        init {
            scenarioLocation.setOnClickListener {
                val position = adapterPosition
                Toast.makeText(itemView.context, "$position " + scenarioLocation.text, Toast.LENGTH_SHORT).show()
            }
        }
    }
}