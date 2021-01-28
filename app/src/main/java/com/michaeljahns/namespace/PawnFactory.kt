package com.michaeljahns.namespace

import android.content.Context
import com.michaeljahns.namespace.grammy.Pawn

object PawnFactory {
    fun getPawns(count: Int): MutableList<Pawn> {
        val pawns = mutableListOf<Pawn>()
        repeat(count) {

        }
        return pawns
    }

    private fun randomPawns(context: Context, crewSize: Int): MutableList<Pawn> {
        val pawnJson = readJsonFromAsset(context, "pirateNames.json")
        val scenarioPawnList = mutableListOf<Pawn>()
        for (j in 1..crewSize) {
            val scenarioPawn = randomPawn(pawnJson)
            scenarioPawnList.add(scenarioPawn)
        }
        return scenarioPawnList
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