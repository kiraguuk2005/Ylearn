package com.example.ylearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ylearn.databinding.ActivitySeniorSecondaryBinding

class SeniorSecondary : AppCompatActivity() {
    private lateinit var binding: ActivitySeniorSecondaryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySeniorSecondaryBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
    }
}