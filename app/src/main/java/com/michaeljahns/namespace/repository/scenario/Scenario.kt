package com.michaeljahns.namespace.repository.scenario

import com.michaeljahns.namespace.repository.pawn.Pawn

data class Scenario(val location: String, val pawns: MutableList<Pawn>) {
    override fun toString(): String {
        return "$location - ${pawns[1]}"
    }
}