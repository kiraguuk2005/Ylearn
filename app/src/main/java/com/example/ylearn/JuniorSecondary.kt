package com.example.ylearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ylearn.databinding.ActivityJuniorSecondaryBinding

class JuniorSecondary : AppCompatActivity() {
    private lateinit var binding: ActivityJuniorSecondaryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityJuniorSecondaryBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
    }
}