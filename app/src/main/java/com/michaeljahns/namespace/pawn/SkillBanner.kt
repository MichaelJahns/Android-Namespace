package com.michaeljahns.namespace.pawn

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import com.michaeljahns.namespace.util.ColorProvider
import com.michaeljahns.namespace.util.TypefaceProvider


class SkillBannerTextView : androidx.appcompat.widget.AppCompatTextView {
    constructor(context: Context) : super(context) {
        TypefaceProvider.setCinzelDecorativeTypeface(context, this)
        ColorProvider.setNamespaceOrangeColor(context, this)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        TypefaceProvider.setCinzelDecorativeTypeface(context, this)
        ColorProvider.setNamespaceOrangeColor(context, this)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        TypefaceProvider.setCinzelDecorativeTypeface(context, this)
        ColorProvider.setNamespaceOrangeColor(context, this)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }
}