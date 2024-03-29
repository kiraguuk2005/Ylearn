package com.example.ylearn

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ylearn.databinding.ActivityLoginBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tvSignUp.setOnClickListener {
            startActivity(Intent(this, Register::class.java))
        }

        binding.btnNext.setOnClickListener {

            registerEvents()


        }
    }

    private fun registerEvents() {
        auth = FirebaseAuth.getInstance()
        binding.btnNext.setOnClickListener {
            val email = binding.emailEt.text.toString().trim()
            val pass = binding.passEt.text.toString().trim()

            if (email.isNotEmpty() && pass.isNotEmpty()) {
                binding.progressBar.visibility = View.VISIBLE
                auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(
                    OnCompleteListener {
                        if (it.isSuccessful) {
                            binding.emailEt.text?.clear()
                            binding.passEt.text?.clear()
                            Toast.makeText(
                                this,
                                "Logged In successfully",
                                Toast.LENGTH_SHORT
                            ).show()

                        } else {
                            Toast.makeText(this, it.exception!!.message, Toast.LENGTH_SHORT)
                                .show()
                        }
                        if (email.isNotEmpty() && pass.isNotEmpty()) {
                            startActivity(Intent(this, Choice::class.java))
                            finish()
                        } else {
                            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT)
                                .show()
                        }
                        binding.progressBar.visibility = View.GONE
                    })
            } else {
                Toast.makeText(
                    this,
                    "Empty Fields Not Allowed",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }
}
