package com.michaeljahns.namespace.pawn

class PawnRepository private constructor(private val pawnDao: PawnDao) {
    fun getPawns() = pawnDao.getPawns()
    fun clearPawns() = pawnDao.clearPawns()
    fun regeneratePawns() = pawnDao.regeneratePawns()

    companion object {
        @Volatile
        private var instance: PawnRepository? = null

        fun getInstance(pawnDao: PawnDao) =
                instance ?: synchronized(this) {
                    instance ?: PawnRepository(pawnDao).also {
                        instance = it
                    }
                }
    }
}