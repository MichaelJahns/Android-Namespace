package com.michaeljahns.namespace.scenario

import com.michaeljahns.namespace.pawn.Pawn

data class Scenario(val location: String, val pawns: MutableList<Pawn>) {
    override fun toString(): String {
        return "$location - ${pawns[1]}"
    }
}