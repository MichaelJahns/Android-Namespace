package com.michaeljahns.namespace.viewmodel.pawn

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.michaeljahns.namespace.repository.pawn.Pawn
import com.michaeljahns.namespace.repository.pawn.StatBlock
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
        val statJson = readJsonFromAsset(context, assetName = "statDistributions.json")
        val pawns = mutableListOf<Pawn>()
        repeat(crewSize) {
            val scenarioPawn = randomPawn(pawnJson, statJson)
            pawns.add(scenarioPawn)
        }
        return pawns
    }

    private fun randomPawn(JSON: String, statJSON: String): Pawn {
        val pawnName = flattenJsonOnKey(JSON, "name")
        val pawnAge = generatePawnAge()
        val pawnProfession = flattenJsonOnKey(JSON, "profession")
        val statSpread: List<List<Int>> = jacksonObjectMapper().readValue(statJSON)
        val pawnStatSpread = getRandomStatSpread(allPossibleStatSpreads = statSpread)
        return Pawn(pawnName, pawnAge, pawnProfession, StatBlock(pawnStatSpread), null)
    }

    private fun generatePawnAge(): Int {
        return rand(minimumAge, maximumAge)
    }

    private fun getRandomStatSpread(allPossibleStatSpreads: List<List<Int>>): List<Int> {
        val length = allPossibleStatSpreads.size
        val randomIndex = rand(0, length - 1)
        return allPossibleStatSpreads[randomIndex]
    }
}