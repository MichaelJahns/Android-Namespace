package com.michaeljahns.namespace.forage

import com.michaeljahns.namespace.util.*

object ForageFactory {
    fun getForages(count: Int): MutableList<Forage> {
        val context = GlobalApplication.getAppContext()
        val forageJson = readJsonFromAsset(context, assetName = "forage.json")
        val forages = mutableListOf<Forage>()
        repeat(count) {
            val forage = randomForage(forageJson)
            forages.add(forage)
        }
        return forages
    }

    private fun randomForage(JSON: String): Forage {
        val flattenedForage = flattenForageFromJson(forageJSON = JSON)
        val forageLandmark = regexIsolateToFirstDash(flattenedForage)
        val forageDescription = regexIsolateEverythingAfterDash(flattenedForage)
        return Forage(forageLandmark, forageDescription)
    }

    private fun flattenForageFromJson(forageJSON: String, key: String = "forage"): String {
        return flattenJsonOnKey(forageJSON, key)
    }
}