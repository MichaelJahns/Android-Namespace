package com.michaeljahns.namespace.util

import android.content.Context
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.michaeljahns.namespace.R

object ColorProvider {
    private var namespaceOrange: Int? = null
    fun setNamespaceOrangeColor(context: Context, tv: TextView) {
        if (namespaceOrange == null) {
            namespaceOrange = ContextCompat.getColor(context, R.color.namespaceOrange)
        }
        tv.setTextColor(namespaceOrange!!)
    }
}