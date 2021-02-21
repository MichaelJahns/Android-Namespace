package com.michaeljahns.namespace.forage

class ForageDatabase private constructor() {

    var forageDao = ForageDao()
        private set

    companion object {
        @Volatile
        private var instance: ForageDatabase? = null

        fun getInstance() =
                instance ?: synchronized(this) {
                    instance ?: ForageDatabase().also {
                        instance = it
                    }
                }
    }
}