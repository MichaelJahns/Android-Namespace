package com.michaeljahns.namespace

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.michaeljahns.namespace.grammy.Scenario

class ViewPageAdapter(private var scenarios: MutableList<Scenario>) : RecyclerView.Adapter<ViewPageAdapter.ViewPager2Holder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPageAdapter.ViewPager2Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.scenario_row, parent, false)
//        Explicating declaring the below resolved some issue, i cant remember now which
        view.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        return ViewPager2Holder(view)
    }

    override fun onBindViewHolder(holder: ViewPageAdapter.ViewPager2Holder, position: Int) {
        val scenario = scenarios[position]
        holder.scenarioLocation.text = scenario.location.toString()
        val childLayoutManager = LinearLayoutManager(holder.scenarioPawnRecycler.context, RecyclerView.HORIZONTAL, false)
        holder.scenarioPawnRecycler.
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
//
//    class ParentAdapter(private val parents: List<ParentModel>) : RecyclerView.Adapter<ParentAdapter.ViewHolder>() {
//        private val viewPool = RecyclerView.RecycledViewPool()
//
//        override fun onBindViewHolder(holder: ViewHolder,
//                                      position: Int) {
//            val parent = parents[position]
//            holder.recyclerView.apply {
//                layoutManager = childLayoutManager
//                adapter = ChildAdapter(parent.children)
//                setRecycledViewPool(viewPool)
//            }
//
//        }
//
//        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//            val recyclerView: RecyclerView = itemView.rv_child
//            val textView: TextView = itemView.textView
//        }
//    }
//}