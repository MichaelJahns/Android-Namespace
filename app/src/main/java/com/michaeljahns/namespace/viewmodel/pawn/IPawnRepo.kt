package com.michaeljahns.namespace.viewmodel.pawn

import androidx.lifecycle.LiveData
import com.michaeljahns.namespace.repository.pawn.Pawn

interface IPawnRepo {
    fun getPawns(): LiveData<List<Pawn>>
    fun generatePawns(): LiveData<List<Pawn>>
    suspend fun insertPawn(pawn: Pawn)
    suspend fun clearPawns()
}