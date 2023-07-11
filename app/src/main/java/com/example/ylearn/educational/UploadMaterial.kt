package com.example.ylearn.educational

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ylearn.databinding.ActivityUploadMaterialBinding

class UploadMaterial : AppCompatActivity() {
    private lateinit var binding: ActivityUploadMaterialBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityUploadMaterialBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
    }
}