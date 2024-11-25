package com.example.organisync.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.organisync.R
import com.example.organisync.databinding.ActivityEventDetailBinding

class EventDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEventDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViews()
        setupListeners()
    }

    private fun setupViews() {
        // Mengatur data event (bisa dari intent atau viewModel)
        binding.apply {
            tvUserName.text = "Danu nasrullah"
            tvUniversity.text = "Universitas Ahmad Dahlan"
            tvEventName.text = "P a r a d o k s"

            // Contoh pengaturan data lainnya
            tvEventDate.text = "25 November 2024"
            tvEventDescription.text = "Deskripsi event akan ditampilkan di sini..."
            tvRegistrationLink.text = "https://example.com/register"

            // Setup bottom navigation
            //bottomNavigation.selectedItemId = R.id.navigation_events
        }
    }

    private fun setupListeners() {
        binding.apply {
            btnBack.setOnClickListener {
                finish()
            }

//            bottomNavigation.setOnItemSelectedListener { menuItem ->
//                when (menuItem.itemId) {
//                    R.id.navigation_home -> {
//                        // Navigate to Home
//                        true
//                    }
//                    R.id.navigation_calendar -> {
//                        // Navigate to Calendar
//                        true
//                    }
//                    R.id.navigation_events -> {
//                        // Already in Events
//                        true
//                    }
//                    R.id.navigation_settings -> {
//                        // Navigate to Settings
//                        true
//                    }
//                    else -> false
//                }
//            }

            // Optional: Make registration link clickable
//            tvRegistrationLink.setOnClickListener {
//                val url = tvRegistrationLink.text.toString()
//                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//                startActivity(intent)
//            }
        }
    }
}