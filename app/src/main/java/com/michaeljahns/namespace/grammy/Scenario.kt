package com.michaeljahns.namespace.grammy

data class Scenario(val location: Location, val pawns: MutableList<Pawn>) {
    override fun toString(): String {
        return "$location - ${pawns[1]}"
    }
}