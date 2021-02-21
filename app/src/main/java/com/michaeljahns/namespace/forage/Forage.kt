package com.michaeljahns.namespace.forage

class Forage(forageLandmark: String, forageDescription: String) {
    val landmark = forageLandmark
    val description = forageDescription
    val discoveries: MutableList<Discovery>? = null
}