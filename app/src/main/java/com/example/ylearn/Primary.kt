package com.example.ylearn

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ylearn.databinding.ActivityPrimaryBinding

class Primary : AppCompatActivity() {
    private lateinit var binding: ActivityPrimaryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPrimaryBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }

    }
}