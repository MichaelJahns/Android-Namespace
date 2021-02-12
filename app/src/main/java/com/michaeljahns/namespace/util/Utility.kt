package com.michaeljahns.namespace.util

import android.content.Context
import com.michaeljahns.namespace.grammy.Forage
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

//Grammy functions
fun flattenForageFromJson(JSON: String?): Forage {
    val forageLocation = flattenJsonOnKey(JSON, "landmark")
    val forageDescription = flattenJsonOnKey(JSON, "description")
    return Forage(forageLocation, forageDescription)
}

fun flattenJsonOnKey(Json: String?, key: String): String {
    val grammar = com.almasb.grammy.Grammy.createGrammar(Json)
    return grammar.flatten(key)
}

// REGEX
fun regexIsolateFirstCapitalWord(JSON: String): String {
//    ^([A-Za-z]+)
    return "Ivy"
}

fun regexIsolateEverythingAfterDash(JSON: String): String {
//    (?<=-).*
    return " poisonous skin irritant"
}

fun regexIsolateToFirstDash(JSON: String): String {
    return "A long abandoned Campsite "
}