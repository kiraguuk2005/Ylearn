package com.example.ylearn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ylearn.databinding.ActivityChoiceBinding
import com.example.ylearn.fragments.AiFragment

class Choice : AppCompatActivity() {

    private lateinit var binding: ActivityChoiceBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityChoiceBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.btnHome.setOnClickListener {
            startActivity(Intent(this, Home::class.java))
        }

        binding.btnAi.setOnClickListener {
            startActivity(Intent(this, Ai::class.java))

        }
    }
}