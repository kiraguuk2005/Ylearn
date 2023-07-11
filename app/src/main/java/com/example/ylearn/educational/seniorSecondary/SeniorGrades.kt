package com.example.ylearn.educational.seniorSecondary

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ylearn.databinding.ActivitySeniorGradesBinding
import com.example.ylearn.educational.sharedClass.StudyMaterials

class SeniorGrades : AppCompatActivity() {
    private lateinit var binding: ActivitySeniorGradesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySeniorGradesBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnGradeTen.setOnClickListener {
            startActivity(Intent(this, StudyMaterials::class.java))
        }
        binding.btnGradeEleven.setOnClickListener {
            startActivity(Intent(this, StudyMaterials::class.java))
        }
        binding.btnGradeTwelve.setOnClickListener {
            startActivity(Intent(this, StudyMaterials::class.java))
        }

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
    }
}