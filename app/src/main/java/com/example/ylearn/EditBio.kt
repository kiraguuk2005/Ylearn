package com.example.ylearn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ylearn.databinding.ActivityEditBioBinding

class EditBio : AppCompatActivity() {

    private lateinit var binding: ActivityEditBioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEditBioBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            startActivity(Intent(this, EditProfile::class.java))
        }

        binding.btnCancel2.setOnClickListener {
            startActivity(Intent(this, EditProfile::class.java))
        }
    }
}