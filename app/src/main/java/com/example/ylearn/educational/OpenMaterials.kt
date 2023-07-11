package com.example.ylearn.educational

import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.appcompat.app.AppCompatActivity
import com.example.ylearn.databinding.ActivityOpenMaterialsBinding

class OpenMaterials : AppCompatActivity() {
    private lateinit var binding: ActivityOpenMaterialsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOpenMaterialsBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.root)

        binding.apply {
            intent

            pdfIcon.setImageResource(intent.getStringExtra("image")!!.toInt())
            pdfTitle.text = intent.getStringExtra("title")
        }

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }

        binding.supportLink.movementMethod = LinkMovementMethod.getInstance()
        binding.supportLink2.movementMethod = LinkMovementMethod.getInstance()


    }
}