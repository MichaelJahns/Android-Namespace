package com.michaeljahns.namespace.factories

import android.content.Context
import com.michaeljahns.namespace.flattenJsonOnKey
import com.michaeljahns.namespace.grammy.Pawn
import com.michaeljahns.namespace.rand
import com.michaeljahns.namespace.readJsonFromAsset

object PawnFactory {
    private var minimumAge: Int = 13
    private var maximumAge: Int = 71
    fun getPawns(context: Context, crewSize: Int): MutableList<Pawn> {
        val pawnJson = readJsonFromAsset(context, "pirateNames.json")
        val sharedPreferences = context.getSharedPreferences("persistentSettings", Context.MODE_PRIVATE)
        minimumAge = sharedPreferences.getInt("MinimumPawnAge", 13)
        maximumAge = sharedPreferences.getInt("MaximumPawnAge", 71)

        val pawns = mutableListOf<Pawn>()
        repeat(crewSize) {
            val scenarioPawn = randomPawn(pawnJson, minimumAge, maximumAge)
            pawns.add(scenarioPawn)
        }
        return pawns
    }

    private fun randomPawn(JSON: String?, minAge: Int, maxAge: Int): Pawn {
        val pawnName = flattenJsonOnKey(JSON, "name")
        val pawnAge = generatePawnAge(minAge, maxAge)
        val pawnProfession = flattenJsonOnKey(JSON, "profession")
        return Pawn(pawnName, pawnAge, pawnProfession)
    }

    private fun generatePawnAge(minAge: Int, maxAge: Int): Int {
        return rand(minAge, maxAge)
    }
}