package com.michaeljahns.namespace.factories

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.michaeljahns.namespace.GlobalApplication
import com.michaeljahns.namespace.flattenForageFromJson
import com.michaeljahns.namespace.grammy.Forage
import com.michaeljahns.namespace.readJsonFromAsset

object ForageFactory {
    fun getForages(count: Int): MutableLiveData<MutableList<Forage>> {
        val forages = MutableLiveData<MutableList<Forage>>()
        forages.value = mutableListOf()
        repeat(count) {
            val context = GlobalApplication.getAppContext()
            val forage = randomForage(context)
            forages.value!!.add(forage)
        }
        return forages
    }

    private fun randomForage(context: Context): Forage {
        val forageJson = readJsonFromAsset(context, "forage.json")
        return flattenForageFromJson(forageJson)
    }

}