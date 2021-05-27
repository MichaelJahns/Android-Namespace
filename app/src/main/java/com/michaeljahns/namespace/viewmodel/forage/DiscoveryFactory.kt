package com.michaeljahns.namespace.viewmodel.forage

import androidx.lifecycle.MutableLiveData
import com.michaeljahns.namespace.repository.forage.Discovery
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
        val flattenDiscovery = flattenDiscoveryFromJson(discoveryJSON = JSON)
        val discoveryName = regexIsolateFirstCapitalWord(flattenDiscovery)
        val discoveryDescription = regexIsolateEverythingAfterDash(flattenDiscovery)
        return Discovery(discoveryName, discoveryDescription)
    }

    private fun flattenDiscoveryFromJson(discoveryJSON: String, key: String = "discoveries"): String {
        return flattenJsonOnKey(discoveryJSON, key)
    }

}