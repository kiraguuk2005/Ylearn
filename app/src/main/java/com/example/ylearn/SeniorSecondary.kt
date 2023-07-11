package com.example.ylearn

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ylearn.databinding.ActivitySeniorSecondaryBinding
import com.example.ylearn.educational.seniorSecondary.SeniorGrades

class SeniorSecondary : AppCompatActivity() {
    private lateinit var binding: ActivitySeniorSecondaryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySeniorSecondaryBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
        binding.btnLegal.setOnClickListener {
            startActivity(Intent(this, SeniorGrades::class.java))
        }
        binding.btnCommunication.setOnClickListener {
            startActivity(Intent(this, SeniorGrades::class.java))
        }
        binding.btnAnatomy.setOnClickListener {
            startActivity(Intent(this, SeniorGrades::class.java))
        }
        binding.btnSport.setOnClickListener {
            startActivity(Intent(this, SeniorGrades::class.java))
        }
        binding.btnGeo.setOnClickListener {
            startActivity(Intent(this, SeniorGrades::class.java))
        }
        binding.btnCre.setOnClickListener {
            startActivity(Intent(this, SeniorGrades::class.java))
        }
        binding.btnIre.setOnClickListener {
            startActivity(Intent(this, SeniorGrades::class.java))
        }
        binding.btnMath.setOnClickListener {
            startActivity(Intent(this, SeniorGrades::class.java))
        }
        binding.btnBiz.setOnClickListener {
            startActivity(Intent(this, SeniorGrades::class.java))
        }
        binding.btnHindu.setOnClickListener {
            startActivity(Intent(this, SeniorGrades::class.java))
        }
        binding.btnHistory.setOnClickListener {
            startActivity(Intent(this, SeniorGrades::class.java))
        }
        binding.btnArabic.setOnClickListener {
            startActivity(Intent(this, SeniorGrades::class.java))
        }
        binding.btnFrench.setOnClickListener {
            startActivity(Intent(this, SeniorGrades::class.java))
        }
        binding.btnGerman.setOnClickListener {
            startActivity(Intent(this, SeniorGrades::class.java))
        }
        binding.btnMandarin.setOnClickListener {
            startActivity(Intent(this, SeniorGrades::class.java))
        }
        binding.btnLiterature.setOnClickListener {
            startActivity(Intent(this, SeniorGrades::class.java))
        }
        binding.btnEnglish.setOnClickListener {
            startActivity(Intent(this, SeniorGrades::class.java))
        }
        binding.btnLugha.setOnClickListener {
            startActivity(Intent(this, SeniorGrades::class.java))
        }
        binding.btnFasihi.setOnClickListener {
            startActivity(Intent(this, SeniorGrades::class.java))
        }
        binding.btnIndigenousLanguages.setOnClickListener {
            startActivity(Intent(this, SeniorGrades::class.java))
        }
        binding.btnBiz.setOnClickListener {
            startActivity(Intent(this, SeniorGrades::class.java))
        }
        binding.btnIct.setOnClickListener {
            startActivity(Intent(this, SeniorGrades::class.java))
        }
        binding.btnCSL.setOnClickListener {
            startActivity(Intent(this, SeniorGrades::class.java))
        }
        binding.btnPE.setOnClickListener {
            startActivity(Intent(this, SeniorGrades::class.java))
        }
        binding.btnMathPure.setOnClickListener {
            startActivity(Intent(this, SeniorGrades::class.java))
        }
        binding.btnPhy.setOnClickListener {
            startActivity(Intent(this, SeniorGrades::class.java))
        }
        binding.btnChem.setOnClickListener {
            startActivity(Intent(this, SeniorGrades::class.java))
        }
        binding.btnBio.setOnClickListener {
            startActivity(Intent(this, SeniorGrades::class.java))
        }
        binding.btnAgriculture.setOnClickListener {
            startActivity(Intent(this, SeniorGrades::class.java))
        }
        binding.btnCs.setOnClickListener {
            startActivity(Intent(this, SeniorGrades::class.java))
        }
        binding.btnHomeManagement.setOnClickListener {
            startActivity(Intent(this, SeniorGrades::class.java))
        }
        binding.btnFoodNutrition.setOnClickListener {
            startActivity(Intent(this, SeniorGrades::class.java))
        }
    }
}