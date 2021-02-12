package com.michaeljahns.namespace.util

import android.content.Context
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
fun flattenJsonOnKey(Json: String?, key: String): String {
    val grammar = com.almasb.grammy.Grammy.createGrammar(Json)
    return grammar.flatten(key)
}
// REGEX
fun regexIsolateFirstCapitalWord(JSON: String): String {
    var pattern = Regex("^([A-Za-z]+)")
    return pattern.find(JSON)!!.value
}

fun regexIsolateEverythingAfterDash(JSON: String): String {
    val pattern = Regex("(?<=-).*")
    return pattern.find(JSON)!!.value
}

fun regexIsolateToFirstDash(JSON: String): String {
    val pattern = "[^.].*(?=-)".toRegex()
    return pattern.find(JSON)!!.value
}