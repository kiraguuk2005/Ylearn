package com.example.ylearn.educational.sharedClass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
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

            pdfIcon.setImageResource(intent.getStringExtra("image")!!.toInt())
            pdfTitle.text = intent.getStringExtra("title")
            pdfDescription.text = intent.getStringExtra("description")
            supportLink.text = intent.getStringExtra("support")
            pdfUrl.text = intent.getStringExtra("pdfUrl")
        }

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }

    }
}