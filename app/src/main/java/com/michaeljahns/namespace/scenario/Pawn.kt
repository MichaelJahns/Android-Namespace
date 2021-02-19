package com.michaeljahns.namespace.scenario

class Pawn(pawnName: String?, pawnAge: Int?, pawnProfession: String?) {
    var name: String? = pawnName
    var age: Int? = pawnAge
    var profession: String? = pawnProfession

    override fun toString(): String {
        return "$name, $profession, age: $age"
    }
}