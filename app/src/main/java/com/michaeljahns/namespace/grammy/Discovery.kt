package com.michaeljahns.namespace.grammy

import com.michaeljahns.namespace.rand

class Discovery(item: String) {
    var item: String = item

    fun generateRarity(): Int {
        return rand(1, 100)
    }
}


