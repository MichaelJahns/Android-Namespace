package com.michaeljahns.namespace.grammy

class Location(locationName: String?) {
    var name: String? = locationName

    override fun toString(): String {
        return name!!
    }
}