package com.michaeljahns.namespace.repository.forage

import com.michaeljahns.namespace.util.rand


class Discovery(val name: String, val description: String) {
    fun generateRarity(): Int {
        return rand(1, 100)
    }
}


