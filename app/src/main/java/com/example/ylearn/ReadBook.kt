package com.example.ylearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.ylearn.databinding.ActivityReadBookBinding

class ReadBook : AppCompatActivity() {
    private lateinit var binding: ActivityReadBookBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityReadBookBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnRead.setOnClickListener {
            launcher.launch("application/pdf")
        }

    }

    private val launcher = registerForActivityResult(ActivityResultContracts.GetContent()){
            uri ->
        uri?.let {
            binding.pdfView.fromUri(it).load()
        }
    }
}