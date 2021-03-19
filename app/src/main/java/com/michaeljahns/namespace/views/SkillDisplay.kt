package com.michaeljahns.namespace.views

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.Gravity
import com.michaeljahns.namespace.util.ColorProvider
import com.michaeljahns.namespace.util.TypefaceProvider

class SkillDisplay : androidx.appcompat.widget.AppCompatTextView {
    constructor(context: Context) : super(context) {
        TypefaceProvider.setJimNightShadeTypeface(context, this)
        ColorProvider.setTextNamespaceBlack(context, this)
        this.textSize = 40F
        this.gravity = Gravity.CENTER
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        TypefaceProvider.setJimNightShadeTypeface(context, this)
        ColorProvider.setTextNamespaceBlack(context, this)
        this.textSize = 40F
        this.gravity = Gravity.CENTER
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        TypefaceProvider.setJimNightShadeTypeface(context, this)
        ColorProvider.setTextNamespaceBlack(context, this)
        this.textSize = 40F
        this.gravity = Gravity.CENTER
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }
}