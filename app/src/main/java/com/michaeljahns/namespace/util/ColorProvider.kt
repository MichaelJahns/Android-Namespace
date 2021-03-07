package com.michaeljahns.namespace.util

import android.content.Context
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.michaeljahns.namespace.R

object ColorProvider {
    private var namespaceOrange: Int? = null
    private var namespaceBlack: Int? = null
    fun setTextNamespaceOrange(context: Context, tv: TextView) {
        if (namespaceOrange == null) {
            namespaceOrange = ContextCompat.getColor(context, R.color.namespaceOrange)
        }
        tv.setTextColor(namespaceOrange!!)
    }

    fun setTextNamespaceBlack(context: Context, tv: TextView) {
        if (namespaceBlack == null) {
            namespaceBlack = ContextCompat.getColor(context, R.color.namespaceBlack)
        }
        tv.setTextColor(namespaceBlack!!)
    }

    fun setBackgroundNamespaceBlack(context: Context, tv: TextView) {
        if (namespaceBlack == null) {
            namespaceBlack = ContextCompat.getColor(context, R.color.namespaceBlack)
        }
//        tv.setBackgroundColor(namespaceBlack!!)
        tv.setBackgroundResource(R.drawable.skill_shape)
    }
}