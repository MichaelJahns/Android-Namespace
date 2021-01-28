package com.michaeljahns.namespace

import android.content.Context
import com.michaeljahns.namespace.grammy.Location
import kotlin.random.Random

@JvmName("Utils")
fun rand(start: Int, end: Int): Int {
    require(start <= end) { "Illegal Argument" }
    val rand = Random(System.nanoTime())
    return (start..end).random(rand)
}

fun readJsonFromAsset(context: Context, assetName: String): String {
    val inputStream = context.assets.open(assetName)
    val buffer = ByteArray(inputStream.available())
    inputStream.read(buffer)
    inputStream.close()
    return String(buffer)
}

fun flattenLocationsFromJson(JSON: String?): Location {
    val locationName = flattenJsonOnKey(JSON, "origin")
    return Location(locationName)
}

fun flattenJsonOnKey(Json: String?, key: String): String {
    val grammar = com.almasb.grammy.Grammy.createGrammar(Json)
    return grammar.flatten(key)
}