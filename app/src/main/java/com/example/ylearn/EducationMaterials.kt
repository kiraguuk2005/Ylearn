package com.example.ylearn

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ylearn.databinding.ActivityEducationMaterialsBinding

class EducationMaterials : AppCompatActivity() {
    private lateinit var binding: ActivityEducationMaterialsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEducationMaterialsBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnPrimary.setOnClickListener {
            startActivity(Intent(this, Primary::class.java))
        }
        binding.btnJuniorSec.setOnClickListener {
            startActivity(Intent(this, JuniorSecondary::class.java))
        }
        binding.btnSeniorSec.setOnClickListener {
            startActivity(Intent(this, SeniorSecondary::class.java))
        }
        binding.btnUnderGrad.setOnClickListener {
            startActivity(Intent(this, UnderGraduate::class.java))
        }
        binding.btn844.setOnClickListener {
            startActivity(Intent(this, Eight44::class.java))
        }

    }
}