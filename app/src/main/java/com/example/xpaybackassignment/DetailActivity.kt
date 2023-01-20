package com.example.xpaybackassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.xpaybackassignment.databinding.ActivityDetailBinding
import com.example.xpaybackassignment.model.User

class DetailActivity : AppCompatActivity() {
    lateinit var binding:ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.userDetailsForDetailScreen = intent.getParcelableExtra<User>("userDetails")

    }
}