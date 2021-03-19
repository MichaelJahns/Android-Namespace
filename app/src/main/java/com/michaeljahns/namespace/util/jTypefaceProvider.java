package com.michaeljahns.namespace.util;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

public class jTypefaceProvider {
    private static Typeface jimNightshade;
    private static Typeface cinzelDecorative;

    public static void setJimNightShadeTypeface(Context context, TextView tv) {
        if (jimNightshade == null) {
            jimNightshade = Typeface.createFromAsset(context.getAssets(), "fonts/JimNightshade-Regular.ttf");
        }
        tv.setTypeface(jimNightshade);
    }
}
