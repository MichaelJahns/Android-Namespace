package com.michaeljahns.namespace.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.michaeljahns.namespace.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private var TAG: String = "Main Process"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}


