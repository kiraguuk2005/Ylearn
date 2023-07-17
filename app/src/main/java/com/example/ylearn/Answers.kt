package com.example.ylearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ylearn.databinding.ActivityAnswersBinding

class Answers : AppCompatActivity() {

    private lateinit var binding: ActivityAnswersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAnswersBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }

        val content = intent.getStringExtra("cont")
        binding.tvContent.text = content




    }
}