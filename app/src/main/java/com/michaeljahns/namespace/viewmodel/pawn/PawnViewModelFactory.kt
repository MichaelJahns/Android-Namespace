package com.michaeljahns.namespace.viewmodel.pawn

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.michaeljahns.namespace.repository.pawn.PawnRepository

class PawnViewModelFactory(private val pawnRepository: PawnRepository)
    : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PawnViewModel(pawnRepository) as T
    }

}