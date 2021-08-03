package com.michaeljahns.namespace.repository.pawn

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pawn_table")
data class Pawn(
        var name: String,
        var age: Int,
        var profession: String,
        val statBlock: StatBlock?,
        @PrimaryKey(autoGenerate = true)
        var pawnId: Int?,
)
