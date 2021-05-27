package com.michaeljahns.namespace.repository.pawn

class StatBlock(pawnStatSpread: List<Int>) {
    var strength: Int? = 1
    var endurance: Int? = 1
    var dexterity: Int? = 1

    var intelligence: Int? = 1
    var mentality: Int? = 1
    var charisma: Int? = 1

    private fun distributeStatSpreadRandomly(statSpread: List<Int>) {
        strength = statSpread[0]
        endurance = statSpread[1]
        dexterity = statSpread[2]

        intelligence = statSpread[3]
        mentality = statSpread[4]
        charisma = statSpread[5]
    }

    private fun shuffleStatSpread(pawnStatSpread: List<Int>): List<Int> {
        return pawnStatSpread.shuffled()
    }

    init {
        val statSpread = shuffleStatSpread(pawnStatSpread)
        distributeStatSpreadRandomly(statSpread)
    }
}