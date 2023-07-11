package com.example.ylearn

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ylearn.databinding.ActivityPrimaryBinding
import com.example.ylearn.educational.primaryGrades.PrimaryGrades

class Primary : AppCompatActivity() {
    private lateinit var binding: ActivityPrimaryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPrimaryBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
        binding.btnKiswahili1.setOnClickListener {
            startActivity(Intent(this, PrimaryGrades::class.java))
        }
        binding.btnHygiene.setOnClickListener {
            startActivity(Intent(this, PrimaryGrades::class.java))
        }
        binding.btnEnvironment.setOnClickListener {
            startActivity(Intent(this, PrimaryGrades::class.java))
        }
        binding.btnReligious.setOnClickListener {
            startActivity(Intent(this, PrimaryGrades::class.java))
        }
        binding.btnLiteracy.setOnClickListener {
            startActivity(Intent(this, PrimaryGrades::class.java))
        }
        binding.btnMath.setOnClickListener {
            startActivity(Intent(this, PrimaryGrades::class.java))
        }
        binding.btnMaths.setOnClickListener {
            startActivity(Intent(this, PrimaryGrades::class.java))
        }
        binding.btnEnglish.setOnClickListener {
            startActivity(Intent(this, PrimaryGrades::class.java))
        }
        binding.btnKiswahili.setOnClickListener {
            startActivity(Intent(this, PrimaryGrades::class.java))
        }
        binding.btnAgriculture.setOnClickListener {
            startActivity(Intent(this, PrimaryGrades::class.java))
        }
        binding.btnSocialStudies.setOnClickListener {
            startActivity(Intent(this, PrimaryGrades::class.java))
        }
        binding.btnCreativeArts.setOnClickListener {
            startActivity(Intent(this, PrimaryGrades::class.java))
        }
        binding.btnPE.setOnClickListener {
            startActivity(Intent(this, PrimaryGrades::class.java))
        }
        binding.btnSciTech.setOnClickListener {
            startActivity(Intent(this, PrimaryGrades::class.java))
        }
        binding.btnCre.setOnClickListener {
            startActivity(Intent(this, PrimaryGrades::class.java))
        }
        binding.btnHomeSci.setOnClickListener {
            startActivity(Intent(this, PrimaryGrades::class.java))
        }
        binding.btnCreative.setOnClickListener {
            startActivity(Intent(this, PrimaryGrades::class.java))
        }

    }
}