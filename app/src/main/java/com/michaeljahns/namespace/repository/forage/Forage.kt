package com.michaeljahns.namespace.repository.forage

class Forage(forageLandmark: String, forageDescription: String) {
    val landmark = forageLandmark
    val description = forageDescription
    val discoveries: MutableList<Discovery>? = null
}