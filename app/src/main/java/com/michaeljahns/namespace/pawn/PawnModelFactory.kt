package com.michaeljahns.namespace.pawn

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PawnModelFactory(private val pawnRepository: PawnRepository)
    : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PawnModel(pawnRepository) as T
    }

}