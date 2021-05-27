package com.michaeljahns.namespace.repository.pawn

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.michaeljahns.namespace.viewmodel.pawn.PawnFactory

class PawnDao {
    private var pawnList = mutableListOf<Pawn>()
    private val pawns = MutableLiveData<List<Pawn>>()

    init {
        regeneratePawns()
    }

    fun getPawns() = pawns as LiveData<List<Pawn>>
    fun clearPawns() {
        pawnList.clear()
    }

    private fun updateLiveData() {
        pawns.value = pawnList
    }

    fun regeneratePawns() {
        clearPawns()
        pawnList = PawnFactory.getPawns(7)
        updateLiveData()
    }


}