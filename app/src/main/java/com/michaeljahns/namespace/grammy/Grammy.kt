package com.michaeljahns.namespace.grammy

import com.almasb.grammy.Grammy

class Grammy {
    fun flattenJSON(Json: String?): String {
        val grammar = Grammy.createGrammar(Json)
        return grammar.flatten("origin")
    }
}