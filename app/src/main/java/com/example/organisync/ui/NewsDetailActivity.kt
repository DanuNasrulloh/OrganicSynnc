package com.example.organisync.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.organisync.R
import com.example.organisync.databinding.ActivityNewsDetailBinding

class NewsDetailActivity : AppCompatActivity() {
    class NewsDetailActivity : AppCompatActivity() {

        private lateinit var binding: ActivityNewsDetailBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityNewsDetailBinding.inflate(layoutInflater)
            setContentView(binding.root)

            // Get data from intent
            val title = intent.getStringExtra("title") ?: ""
            val imageUrl = intent.getStringExtra("imageUrl") ?: ""
            val organization = intent.getStringExtra("organization") ?: ""
            val university = intent.getStringExtra("university") ?: ""
            val description = intent.getStringExtra("description") ?: ""

            // Set data to views
            with(binding) {
                tvTitle.text = title
                tvOrganization.text = organization
                tvUniversity.text = university
                tvDescription.text = description

                // Load image using Glide (make sure to add Glide dependency)
                Glide.with(this@NewsDetailActivity)
                    .load(imageUrl)
                    //.placeholder(R.drawable.placeholder_image)
                    .into(ivNews)

                // Handle back button click
                btnBack.setOnClickListener {
                    finish()
                }
            }
        }

        companion object {
            fun start(context: Context, newsData: NewsData) {
                val intent = Intent(context, NewsDetailActivity::class.java).apply {
                    putExtra("title", newsData.title)
                    putExtra("imageUrl", newsData.imageUrl)
                    putExtra("organization", newsData.organization)
                    putExtra("university", newsData.university)
                    putExtra("description", newsData.description)
                }
                context.startActivity(intent)
            }
        }
    }

    // Data class for news
    data class NewsData(
        val title: String,
        val imageUrl: String,
        val organization: String,
        val university: String,
        val description: String
    )