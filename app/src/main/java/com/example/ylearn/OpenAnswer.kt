package com.example.ylearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ylearn.databinding.ActivityOpenAnswerBinding

class OpenAnswer : AppCompatActivity() {
    private lateinit var binding : ActivityOpenAnswerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityOpenAnswerBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }

        binding.apply {
            intent

            imageView.setImageResource(intent.getStringExtra("image")!!.toInt())
            tvUserName.text = intent.getStringExtra("user")
            tvTopic.text = intent.getStringExtra("topic")
            tvTime.text = intent.getStringExtra("time")
            tvContent.text = intent.getStringExtra("message")
        }
    }
}