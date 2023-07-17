package com.example.ylearn

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ylearn.databinding.ActivityQuestionDetailBinding

class QuestionDetail : AppCompatActivity() {
    private lateinit var binding: ActivityQuestionDetailBinding
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

        binding.tvPostAnswer.setOnClickListener {
            val content = binding.tvContent.text.toString()
            val intent = Intent(this, Answers::class.java)
            intent.putExtra("cont", content)
            startActivity(intent)
        }

    }

}