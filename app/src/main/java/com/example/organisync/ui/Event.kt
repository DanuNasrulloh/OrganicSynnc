package com.example.organisync.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.organisync.R
import com.google.android.material.button.MaterialButton

class Event : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        setupViews()
    }

    private fun setupViews() {
        // Initialize the Create Event button click listener
        findViewById<MaterialButton>(R.id.btnCreateEvent).setOnClickListener {
            // Handle create event button click
            // You can add your navigation or dialog logic here
        }
    }
}