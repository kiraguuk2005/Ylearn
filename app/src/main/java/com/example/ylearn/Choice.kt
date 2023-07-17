package com.example.ylearn

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ylearn.databinding.ActivityChoiceBinding

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
        binding.btnEarn.setOnClickListener {
            startActivity(Intent(this, EducationMaterials::class.java))

        }
        binding.btnbooks.setOnClickListener {
            startActivity(Intent(this, Books::class.java))
        }
    }


}