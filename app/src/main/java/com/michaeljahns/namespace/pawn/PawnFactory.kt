package com.michaeljahns.namespace.pawn
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
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
            val scenarioPawn = randomPawn(pawnJson, statJson, minimumAge, maximumAge)
            pawns.add(scenarioPawn)
        }
        return pawns
    }

    private fun randomPawn(JSON: String, statJSON: String, minAge: Int, maxAge: Int): Pawn {
        val pawnName = flattenJsonOnKey(JSON, "name")
        val pawnAge = generatePawnAge(minAge, maxAge)
        val pawnProfession = flattenJsonOnKey(JSON, "profession")
        val pawnStats = getRandomStatArray(statJSON)
        return Pawn(pawnName, pawnAge, pawnProfession, StatBlock())
    }

    private fun generatePawnAge(minAge: Int, maxAge: Int): Int {
        return rand(minAge, maxAge)
    }

    private fun flattenPawnFromJson(pawnJSON: String, key: String = "pawn"): String {
        return flattenJsonOnKey(pawnJSON, key)
    }

    private fun getRandomStatArray(JSON: String): Int {
        val mapper = jacksonObjectMapper()
        val allStats: List<Array<Int>> = mapper.readValue(JSON)
        val length = allStats.size
        return 7
    }

}