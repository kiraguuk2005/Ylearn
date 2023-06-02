package com.example.ylearn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ylearn.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            startActivity(Intent(this, Choice::class.java))
            finish()
        }

        binding.tvSignUp.setOnClickListener {
            startActivity(Intent(this, Register::class.java))
        }
    }
}