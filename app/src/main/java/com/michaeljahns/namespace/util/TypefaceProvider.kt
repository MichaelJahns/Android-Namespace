package com.michaeljahns.namespace.util

import android.content.Context
import android.graphics.Typeface
import android.widget.TextView

object TypefaceProvider {
    private var jimNightshade: Typeface? = null
    private var cinzelDecorative: Typeface? = null
    fun setJimNightShadeTypeface(context: Context, tv: TextView) {
        if (jimNightshade == null) {
            jimNightshade = Typeface.createFromAsset(context.assets, "fonts/JimNightshade-Regular.ttf")
        }
        tv.typeface = jimNightshade
    }

    fun setCinzelDecorativeTypeface(context: Context, tv: TextView) {
        if (cinzelDecorative == null) {
            cinzelDecorative = Typeface.createFromAsset(context.assets, "fonts/CinzelDecorative-Regular.ttf")
        }
        tv.typeface = cinzelDecorative
    }
}