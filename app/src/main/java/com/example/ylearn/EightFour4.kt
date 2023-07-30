package com.example.ylearn

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ylearn.databinding.ActivityEightFour4Binding
import com.example.ylearn.educational.sharedClass.SyllabusMaterials

class EightFour4 : AppCompatActivity() {
    private lateinit var binding: ActivityEightFour4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEightFour4Binding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnClassEight.setOnClickListener {
            startActivity(Intent(this, SyllabusMaterials::class.java))
        }

        binding.btnForm1.setOnClickListener {
            startActivity(Intent(this, SyllabusMaterials::class.java))
        }

        binding.btnForm2.setOnClickListener {
            startActivity(Intent(this, SyllabusMaterials::class.java))
        }

        binding.btnForm3.setOnClickListener {
            startActivity(Intent(this, SyllabusMaterials::class.java))
        }

        binding.btnForm4.setOnClickListener {
            startActivity(Intent(this, SyllabusMaterials::class.java))
        }
    }
}