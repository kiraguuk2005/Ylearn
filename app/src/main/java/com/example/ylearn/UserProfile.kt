package com.example.ylearn

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ylearn.databinding.ActivityUserProfileBinding

class UserProfile : AppCompatActivity() {

    private lateinit var binding: ActivityUserProfileBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityUserProfileBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        binding.editProfile.setOnClickListener {
            startActivity(
                Intent(this, EditProfile::class.java)
            )
        }

        binding.ivSettings.setOnClickListener {
            startActivity(
                Intent(this, Settings::class.java)
            )
        }

        binding.ivBack.setOnClickListener {
            startActivity(
                Intent(this, Home::class.java)
            )
        }

    }

}