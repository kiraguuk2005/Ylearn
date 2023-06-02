package com.example.ylearn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ylearn.databinding.ActivityFloatingFormBinding

class FloatingForm : AppCompatActivity() {

    private lateinit var binding: ActivityFloatingFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFloatingFormBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener {
            startActivity(Intent(this, Home::class.java))
        }

        binding.btnPost.setOnClickListener {
            startActivity(Intent(this, Home::class.java))
        }
    }
}