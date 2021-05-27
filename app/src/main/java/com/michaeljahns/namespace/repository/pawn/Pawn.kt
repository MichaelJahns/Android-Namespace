package com.michaeljahns.namespace.repository.pawn

class Pawn(pawnName: String?,
           pawnAge: Int?,
           pawnProfession: String?,
           pawnStats: StatBlock?) {
    var name: String? = pawnName
    var age: Int? = pawnAge
    var profession: String? = pawnProfession
    val statBlock: StatBlock? = pawnStats

    override fun toString(): String {
        return "$name, $profession, age: $age"
    }
}