package com.example.ylearn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ylearn.databinding.ActivityEditUserNameBinding

class EditUserName : AppCompatActivity() {

    private lateinit var binding: ActivityEditUserNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding =  ActivityEditUserNameBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnCancel.setOnClickListener {
            startActivity(Intent(this, EditProfile::class.java))
        }

        binding.btnSave.setOnClickListener {
            startActivity(Intent(this, EditProfile::class.java))
        }
    }
}