package com.example.ylearn.educational.primaryGrades

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ylearn.databinding.ActivityPrimaryGradesBinding
import com.example.ylearn.educational.sharedClass.StudyMaterials

class PrimaryGrades : AppCompatActivity() {
    private lateinit var binding: ActivityPrimaryGradesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPrimaryGradesBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnGradeOne.setOnClickListener {
            startActivity(Intent(this, StudyMaterials::class.java))
        }
        binding.btnGradeTwo.setOnClickListener {
            startActivity(Intent(this, StudyMaterials::class.java))
        }
        binding.btnGradeThree.setOnClickListener {
            startActivity(Intent(this, StudyMaterials::class.java))
        }
        binding.btnGradeFour.setOnClickListener {
            startActivity(Intent(this, StudyMaterials::class.java))
        }
        binding.btnGradeFive.setOnClickListener {
            startActivity(Intent(this, StudyMaterials::class.java))
        }
        binding.btnGradeSix.setOnClickListener {
            startActivity(Intent(this, StudyMaterials::class.java))
        }

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
    }
}