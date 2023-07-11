package com.example.ylearn

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ylearn.databinding.ActivityJuniorSecondaryBinding
import com.example.ylearn.educational.JuniorSecondary.JuniorGrades

class JuniorSecondary : AppCompatActivity() {
    private lateinit var binding: ActivityJuniorSecondaryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityJuniorSecondaryBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
        binding.btnKiswahili1.setOnClickListener {
            startActivity(
                Intent(this, JuniorGrades::class.java)
            )
        }
        binding.btnEnglish.setOnClickListener {
            startActivity(
                Intent(this, JuniorGrades::class.java)
            )
        }
        binding.btnMath.setOnClickListener {
            startActivity(
                Intent(this, JuniorGrades::class.java)
            )
        }
        binding.btnInterSci.setOnClickListener {
            startActivity(
                Intent(this, JuniorGrades::class.java)
            )
        }
        binding.btnHealth.setOnClickListener {
            startActivity(
                Intent(this, JuniorGrades::class.java)
            )
        }
        binding.btnLifeSkills.setOnClickListener {
            startActivity(
                Intent(this, JuniorGrades::class.java)
            )
        }
        binding.bntSST.setOnClickListener {
            startActivity(
                Intent(this, JuniorGrades::class.java)
            )
        }
        binding.btnCre.setOnClickListener {
            startActivity(
                Intent(this, JuniorGrades::class.java)
            )
        }
        binding.btnBiz.setOnClickListener {
            startActivity(
                Intent(this, JuniorGrades::class.java)
            )
        }
        binding.btnAgriculture.setOnClickListener {
            startActivity(
                Intent(this, JuniorGrades::class.java)
            )
        }
        binding.btnPreTech.setOnClickListener {
            startActivity(
                Intent(this, JuniorGrades::class.java)
            )
        }
        binding.btnSport.setOnClickListener {
            startActivity(
                Intent(this, JuniorGrades::class.java)
            )
        }
        binding.btnHomeSci.setOnClickListener {
            startActivity(
                Intent(this, JuniorGrades::class.java)
            )
        }
        binding.btnCompSci.setOnClickListener {
            startActivity(
                Intent(this, JuniorGrades::class.java)
            )
        }
    }
}