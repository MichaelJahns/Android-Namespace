package com.michaeljahns.namespace.ui.views

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.view.marginBottom

class SkillFrame : FrameLayout {
    
    constructor(context: Context) : super(context) {
        this.layoutParams = LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT)
        this.marginBottom
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        this.layoutParams = LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        this.layoutParams = LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }
}