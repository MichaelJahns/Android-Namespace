package com.michaeljahns.namespace.pawn

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class PawnDao {
    private var pawnList = mutableListOf<Pawn>()
    private val pawns = MutableLiveData<List<Pawn>>()

    init {
        regeneratePawns()
    }

    fun getPawns() = pawns as LiveData<List<Pawn>>
    
    fun regeneratePawns() {
        clearPawns()
        pawnList = PawnFactory.getPawns(7)
        updateLiveData()
    }

    private fun updateLiveData() {
        pawns.value = pawnList
    }

    fun clearPawns() {
        pawnList.clear()
    }


}