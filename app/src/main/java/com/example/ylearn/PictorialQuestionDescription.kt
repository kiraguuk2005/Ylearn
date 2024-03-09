package com.example.ylearn

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.ylearn.databinding.ActivityPictorialQuestioDescriptionBinding

class PictorialQuestionDescription : AppCompatActivity() {
    private lateinit var binding: ActivityPictorialQuestioDescriptionBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPictorialQuestioDescriptionBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
        Glide.with(this)
            .load(intent.getStringExtra("image"))
            .into(binding.selectImage)
        binding.apply {
            intent
            quizTitle.text = intent.getStringExtra("quizTitle")
            quizDescription.text = intent.getStringExtra("quizDescription")

        }
    }
}