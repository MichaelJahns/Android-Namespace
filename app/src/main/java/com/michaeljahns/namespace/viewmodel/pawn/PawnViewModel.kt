package com.michaeljahns.namespace.viewmodel.pawn

import androidx.lifecycle.ViewModel
import com.michaeljahns.namespace.repository.pawn.PawnRepository

class PawnViewModel(private val pawnRepository: PawnRepository)
    : ViewModel() {
    var tester: String = "You found me"
    fun getPawns() = pawnRepository.getPawns()
    fun clearPawns() = pawnRepository.clearPawns()
    fun regeneratePawns() = pawnRepository.regeneratePawns()
}