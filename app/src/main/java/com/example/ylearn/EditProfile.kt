package com.example.ylearn

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ylearn.databinding.ActivityEditProfileBinding
import com.example.ylearn.model.profile.Profile
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import java.util.*

class EditProfile : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private lateinit var storage: FirebaseStorage
    private lateinit var selectedImg: Uri

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

        database = FirebaseDatabase.getInstance()
        storage = FirebaseStorage.getInstance()
        auth = FirebaseAuth.getInstance()

        binding.ivProfileImage.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_GET_CONTENT
            intent.type = "image/*"
            startActivityForResult(intent, 1)
        }

        binding.btnSave.setOnClickListener {
            uploadData()
        }
    }

    private fun uploadData() {
        val reference = storage.reference.child("Profile Pics").child(Date().time.toString())
        reference.putFile(selectedImg).addOnCompleteListener {
            if (it.isSuccessful) {
                reference.downloadUrl.addOnSuccessListener { task ->
                    uploadInfo(task.toString())

                }
            }
        }

    }

    private fun uploadInfo(imgUrl: String) {
        val user = Profile(auth.uid.toString(), imgUrl)
        database.reference.child("Users")
            .child(auth.uid.toString())
            .setValue(user)
            .addOnSuccessListener {
                Toast.makeText(this, "Uploaded Successfully", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, UserProfile::class.java))
                finish()
            }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (data != null) {
            if (data.data != null) {
                selectedImg = data.data!!
                binding.ivProfileImage.setImageURI(selectedImg)
            }
        }
    }


}