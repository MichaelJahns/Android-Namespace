package com.michaeljahns.namespace.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.michaeljahns.namespace.R

//this is the main entry point into the app, this is the launch activity, there is a brief, scripted
//delay here which will someday be replaced with loading screen that fetches from whatever API we
//end up using

class SplashActivity : AppCompatActivity() {
    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        handler = Handler()
        handler.postDelayed({
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            this.finish()
            finish()
        }, 1500)

//       Splash Leyline Animation
//        Splash Sound Accompaniment
    }
}