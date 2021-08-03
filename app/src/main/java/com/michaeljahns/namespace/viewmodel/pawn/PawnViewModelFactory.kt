package com.michaeljahns.namespace.viewmodel.pawn

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.michaeljahns.namespace.repository.pawn.PawnRepository

class PawnViewModelFactory(
        private val mApplication: Application
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PawnViewModel(PawnRepository(mApplication)) as T
    }

}