package com.michaeljahns.namespace.viewmodel.pawn

import androidx.lifecycle.ViewModel
import com.michaeljahns.namespace.repository.pawn.Pawn
import com.michaeljahns.namespace.repository.pawn.PawnRepository

class PawnViewModel(private val pawnRepository: PawnRepository)
    : ViewModel() {
    fun getPawns() = pawnRepository.getPawns()
    fun generatePawns() = pawnRepository.generatePawns()
    suspend fun clearPawns() = pawnRepository.clearPawns()
    suspend fun insertPawn(pawn: Pawn) {
        pawnRepository.insertPawn(pawn)
    }
}