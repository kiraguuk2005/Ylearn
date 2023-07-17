package com.example.ylearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ylearn.databinding.ActivityQuestionDetailBinding

class QuestionDetail : AppCompatActivity() {
    private lateinit var binding : ActivityQuestionDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityQuestionDetailBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }

        binding.apply {
            intent

            imageView.setImageResource(intent.getStringExtra("image")!!.toInt())
            tvUserName.text = intent.getStringExtra("username")
            tvTopic.text = intent.getStringExtra("topic")
            tvTime.text = intent.getStringExtra("time")
            tvContent.text = intent.getStringExtra("content")


        }
    }
}