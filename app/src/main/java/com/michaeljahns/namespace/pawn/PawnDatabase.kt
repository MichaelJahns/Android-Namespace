package com.michaeljahns.namespace.pawn

class PawnDatabase private constructor() {

    var pawnDao = PawnDao()
        private set

    companion object {
        @Volatile
        private var instance: PawnDatabase? = null

        fun getInstance() =
                instance ?: synchronized(this) {
                    instance ?: PawnDatabase().also {
                        instance = it
                    }
                }
    }
}
