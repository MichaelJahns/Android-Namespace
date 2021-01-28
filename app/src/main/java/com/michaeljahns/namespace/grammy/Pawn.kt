package com.michaeljahns.namespace.grammy

class Pawn {
    var name: String? = null
    var age: Int? = null
    var profession: String? = null

    constructor(pawnName: String?, pawnAge: Int?, pawnProfession: String?) {
        name = pawnName
        age = pawnAge
        profession = pawnProfession
    }

    override fun toString(): String {
        return "$name, $profession, age: $age"
    }
}