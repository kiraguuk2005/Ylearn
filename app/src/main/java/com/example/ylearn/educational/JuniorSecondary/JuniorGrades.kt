package com.example.ylearn.educational.JuniorSecondary

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ylearn.databinding.ActivityJuniorGradesBinding
import com.example.ylearn.educational.sharedClass.StudyMaterials

class JuniorGrades : AppCompatActivity() {
    private lateinit var binding: ActivityJuniorGradesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityJuniorGradesBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnGradeSeven.setOnClickListener {
            startActivity(Intent(this, StudyMaterials::class.java))
        }
        binding.btnGradeEight.setOnClickListener {
            startActivity(Intent(this, StudyMaterials::class.java))
        }
        binding.btnGradeNine.setOnClickListener {
            startActivity(Intent(this, StudyMaterials::class.java))
        }
        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
    }
}