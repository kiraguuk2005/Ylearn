package com.example.ylearn

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ylearn.databinding.ActivityEditProfileBinding

class EditProfile : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivEditUserName.setOnClickListener {
            startActivity(Intent(this, EditUserName::class.java))
        }

        binding.ivEditBio.setOnClickListener {
            startActivity(
                Intent(
                    this, EditBio::class.java
                )
            )
        }

        binding.ivBack.setOnClickListener {
            startActivity(Intent(this, UserProfile::class.java))
        }
    }

}