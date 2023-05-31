package com.example.ylearn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ylearn.databinding.ActivityAccountInfoBinding

class AccountInfo : AppCompatActivity() {

    private lateinit var binding: ActivityAccountInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding =  ActivityAccountInfoBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivClose.setOnClickListener {
            startActivity(Intent(this, Account::class.java))
        }
    }
}