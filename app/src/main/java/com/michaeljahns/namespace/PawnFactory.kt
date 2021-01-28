package com.michaeljahns.namespace

import android.content.Context
import com.michaeljahns.namespace.grammy.Pawn

object PawnFactory {
    fun getPawns(context: Context, crewSize: Int): MutableList<Pawn> {
        val pawnJson = readJsonFromAsset(context, "pirateNames.json")
        val pawns = mutableListOf<Pawn>()
        repeat(crewSize) {
            val scenarioPawn = randomPawn(pawnJson)
            pawns.add(scenarioPawn)
        }
        return pawns
    }

    private fun randomPawn(JSON: String?): Pawn {
        val pawnName = flattenJsonOnKey(JSON, "name")
        val pawnAge = generatePawnAge()
        val pawnProfession = flattenJsonOnKey(JSON, "profession")
        return Pawn(pawnName, pawnAge, pawnProfession)
    }

    private fun generatePawnAge(): Int {
        val minAge = 13
        val maxAge = 69
        return rand(minAge, maxAge)
    }

}