package com.example.ylearn

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ylearn.databinding.ActivityRegisterBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class Register : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth
    private val TAG = "Register"

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tvSignIn.setOnClickListener {
            startActivity(Intent(this, Login::class.java))

        }
        binding.btnRegister.setOnClickListener {
            registerEvents()
        }

    }

    private var user = ""
    private var email = ""
    private var phone = ""

    private fun registerEvents() {
        auth = FirebaseAuth.getInstance()
        binding.btnRegister.setOnClickListener {
            email = binding.etEmail.text.toString().trim()
            val pass = binding.passEt.text.toString().trim()
            user = binding.userName.text.toString().trim()
            phone = binding.etPhone.text.toString().trim()
            val verifyPass = binding.verifyPassEt.text.toString().trim()

            if (email.isNotEmpty() && pass.isNotEmpty() && verifyPass.isNotEmpty()) {
                if (pass == verifyPass) {
                    binding.progressBar.visibility = View.VISIBLE
                    auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(
                        OnCompleteListener {
                            if (it.isSuccessful) {

                                createUserDetails(timeStamp)

                                binding.etEmail.text?.clear()
                                binding.passEt.text?.clear()
                                binding.userName.text?.clear()
                                binding.etPhone.text?.clear()
                                binding.verifyPassEt.text?.clear()
                                Toast.makeText(
                                    this,
                                    "Registration successful",
                                    Toast.LENGTH_SHORT
                                ).show()

                            } else {
                                Toast.makeText(this, it.exception!!.message, Toast.LENGTH_SHORT)
                                    .show()
                            }
                            if (email.isNotEmpty() && pass.isNotEmpty() && user.isNotEmpty() && phone.isNotEmpty() && verifyPass.isNotEmpty()) {
                                startActivity(Intent(this, Login::class.java))
                                finish()
                            } else {
                                Toast.makeText(
                                    this,
                                    "Please fill in all fields",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            binding.progressBar.visibility = View.GONE
                        })
                } else {
                    Toast.makeText(
                        this,
                        "Passwords Don't Match",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            } else {
                Toast.makeText(
                    this,
                    "Empty Fields Not Allowed",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }


    val timeStamp = System.currentTimeMillis()
    private fun createUserDetails(timeStamp: Long) {
        Log.d(TAG, "Uploading to Database")
        val uid = FirebaseAuth.getInstance().uid
        val hashMap: HashMap<String, Any> = HashMap()

        hashMap["uid"] = "$uid"
        hashMap["Name"] = "$user"
        hashMap["Email"] = "$email"
        hashMap["PhoneNumber"] = "$phone"

        val ref = FirebaseDatabase.getInstance().getReference("registeredUser")
        ref.child("$timeStamp")
            .setValue(hashMap)
            .addOnSuccessListener {
                Log.d(TAG, "Registered")
                Toast.makeText(
                    this,
                    "Registered Succesfully",
                    Toast.LENGTH_SHORT
                ).show()

            }
            .addOnFailureListener { e ->
                Log.d(TAG, "Uploading to Storage Failed due to ${e.message}")
                Toast.makeText(
                    this,
                    "Registration Failed due to ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()

            }
    }
}

