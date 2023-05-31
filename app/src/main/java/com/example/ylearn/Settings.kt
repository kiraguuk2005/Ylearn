package com.example.ylearn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ylearn.databinding.ActivitySetingsBinding

class Settings : AppCompatActivity() {

    private lateinit var binding: ActivitySetingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding  = ActivitySetingsBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tvLogout.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }

        binding.ivBack.setOnClickListener {
            startActivity(Intent(this, UserProfile::class.java))
        }

        binding.ivToAccount.setOnClickListener {
            startActivity(Intent(this, Account::class.java))
        }

    }
}