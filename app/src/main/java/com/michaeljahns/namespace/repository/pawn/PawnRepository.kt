package com.michaeljahns.namespace.repository.pawn

import android.app.Application
import androidx.lifecycle.LiveData
import com.michaeljahns.namespace.database.PawnDatabase
import com.michaeljahns.namespace.viewmodel.pawn.IPawnRepo

class PawnRepository(
        application: Application
) : IPawnRepo {
    private val pawnDao: IPawnDatabase

    //    val generatedPawns: LiveData<List<Pawn>>
    private val savedPawns: LiveData<List<Pawn>>

    init {
        val db = PawnDatabase.getInstance(application)
        pawnDao = db.pawnDao()
//        generatedPawns = someFactory.generatePawns()
        savedPawns = getPawns()
    }

    //    OVERRIDES
    override fun getPawns(): LiveData<List<Pawn>> {
        return pawnDao.getAllPawns()
    }

    override fun generatePawns(): LiveData<List<Pawn>> {
        TODO("generatedPawns is commented out for now")
    }

    override suspend fun insertPawn(pawn: Pawn) {
        return pawnDao.insertPawn(pawn)
    }

    override suspend fun clearPawns() {
        return pawnDao.deleteAllPawns()
    }
}