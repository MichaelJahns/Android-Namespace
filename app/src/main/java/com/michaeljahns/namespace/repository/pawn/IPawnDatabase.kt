package com.michaeljahns.namespace.repository.pawn

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface IPawnDatabase {
    @Query("SELECT * FROM pawn_table")
    fun getAllPawns(): LiveData<List<Pawn>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPawn(pawn: Pawn)

    @Query("DELETE FROM pawn_table")
    suspend fun deleteAllPawns()

}