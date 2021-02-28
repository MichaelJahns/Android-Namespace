package com.michaeljahns.namespace.pawn

import androidx.lifecycle.ViewModel

class PawnModel(private val pawnRepository: PawnRepository)
    : ViewModel() {

    fun getPawns() = pawnRepository.getPawns()
    fun clearPawns() = pawnRepository.clearPawns()
    fun regeneratePawns() = pawnRepository.regeneratePawns()
}