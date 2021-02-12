package com.michaeljahns.namespace.factories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.michaeljahns.namespace.grammy.Discovery
import com.michaeljahns.namespace.util.*

object DiscoveryFactory {
    fun getDiscoveries(count: Int): MutableLiveData<MutableList<Discovery>> {
        val context = GlobalApplication.getAppContext()
        val discoveryJson = readJsonFromAsset(context, assetName = "discovery.json")
        val discoveries = MutableLiveData<MutableList<Discovery>>()
        discoveries.value = mutableListOf()
        repeat(count) {
            val discovery = randomDiscovery(discoveryJson)
            discoveries.value!!.add(discovery)
        }
        return discoveries
    }

    private fun randomDiscovery(JSON: String): Discovery {
        Log.d("DISCOVERY FACTORY", JSON)
        val flattenDiscovery = flattenDiscoveryFromJson(discoveryJSON = JSON)
        val discoveryName = regexIsolateFirstCapitalWord(flattenDiscovery)
        val discoveryDescription = regexIsolateEverythingAfterDash(flattenDiscovery)
        return Discovery(discoveryName, discoveryDescription)
    }

    private fun flattenDiscoveryFromJson(discoveryJSON: String, key: String = "discoveries"): String {
        return flattenJsonOnKey(discoveryJSON, key)
    }

}