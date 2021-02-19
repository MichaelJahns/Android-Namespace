package com.michaeljahns.namespace.factories

import com.michaeljahns.namespace.scenario.Pawn
import com.michaeljahns.namespace.util.GlobalApplication
import com.michaeljahns.namespace.util.flattenJsonOnKey
import com.michaeljahns.namespace.util.rand
import com.michaeljahns.namespace.util.readJsonFromAsset

object PawnFactory {
    private var minimumAge: Int = 13
    private var maximumAge: Int = 71
    fun getPawns(crewSize: Int): MutableList<Pawn> {
        val context = GlobalApplication.getAppContext()
        val pawnJson = readJsonFromAsset(context, assetName = "pirateNames.json")
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
        //        potential different pattern
        //        val flattenedPawn = flattenPawnFromJson(pawnJSON = JSON)
        //        val pawnName = regexIsolateFirstCapitalWord(flattenedPawn)
        //        val pawnBackstory = regexIsolateEverythingAfterDash(flattenedPawn)
        //        val pawnAge = regexSomeththing(flattenedPawn)
        //
        //        return Pawn(pawnName, pawnBackstory, pawnProfession
    }

    private fun generatePawnAge(minAge: Int, maxAge: Int): Int {
        return rand(minAge, maxAge)
    }

    private fun flattenPawnFromJson(pawnJSON: String, key: String = "pawn"): String {
        return flattenJsonOnKey(pawnJSON, key)
    }
}