package com.michaeljahns.namespace.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.michaeljahns.namespace.repository.pawn.IPawnDatabase
import com.michaeljahns.namespace.repository.pawn.Pawn

@Database(entities = [(Pawn::class)], version = 1)
abstract class PawnDatabase : RoomDatabase() {

    abstract fun pawnDao(): IPawnDatabase

    companion object {
        @Volatile
        private var INSTANCE: PawnDatabase? = null

        fun getInstance(context: Context): PawnDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context,
                            PawnDatabase::class.java,
                            "pawn_database"
                    )
                            .fallbackToDestructiveMigration()
                            .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
