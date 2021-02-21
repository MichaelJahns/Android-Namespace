package com.michaeljahns.namespace.forage

class ForageRepository private constructor(private val forageDao: ForageDao) {
    fun getForages() = forageDao.getForages()
    fun regenerateForages() = forageDao.regenerateForages()
    fun clearForages() = forageDao.clearForages()

    companion object {
        @Volatile
        private var instance: ForageRepository? = null

        fun getInstance(forageDao: ForageDao) =
                instance ?: synchronized(this) {
                    instance ?: ForageRepository(forageDao).also {
                        instance = it
                    }
                }
    }

}