package com.michaeljahns.namespace

import android.util.Log
import android.view.View

interface OmniFragment {
    val TAG: String
    fun onOmniFabClicked(view: View) {
        Log.d(TAG, "Omni-Clicked")
    }
}