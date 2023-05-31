package com.example.ylearn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ylearn.databinding.ActivityPasswordSettingBinding

class PasswordSetting : AppCompatActivity() {

    private lateinit var binding: ActivityPasswordSettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityPasswordSettingBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnCancel.setOnClickListener {
            startActivity(Intent(this, Account::class.java))
        }

        binding.btnSave.setOnClickListener {
            startActivity(Intent(this, Account::class.java))
        }
    }
}