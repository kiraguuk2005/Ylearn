package com.example.ylearn.educational.sharedClass

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ylearn.databinding.ActivityOpenMaterialsBinding

class OpenMaterials : AppCompatActivity() {
    private lateinit var binding: ActivityOpenMaterialsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityOpenMaterialsBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            intent

            pdfTitle.text = intent.getStringExtra("title")
            pdfDescription.text = intent.getStringExtra("description")
            supportLink.text = intent.getStringExtra("support")

        }

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }

    }
}