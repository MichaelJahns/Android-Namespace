package com.michaeljahns.namespace.scenario

class Location(locationName: String?) {
    var name: String? = locationName

    override fun toString(): String {
        return name!!
    }
}