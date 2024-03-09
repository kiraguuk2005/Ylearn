package com.example.ylearn

import android.app.ProgressDialog
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.ylearn.databinding.ActivityAdvertiseBinding
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage

class Advertise : AppCompatActivity() {

    private lateinit var binding: ActivityAdvertiseBinding

    private var imageUri: Uri? = null
    private val selectImage = registerForActivityResult(ActivityResultContracts.GetContent()) {
        imageUri = it
        binding.selectImage.setImageURI(imageUri)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAdvertiseBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.selectImage.setOnClickListener {
            selectImage.launch("image/*")
        }

        binding.uploadBtn.setOnClickListener {
            validateData()
        }
    }

    private var adTitle = ""
    private var adContact = ""
    private var adDesc = ""
    private var adImage = ""
    private fun validateData() {
        adTitle = binding.title.text.toString().trim()
        adContact = binding.contactInfo.text.toString().trim()
        adDesc = binding.desc.text.toString()
        adImage = binding.selectImage.toString().trim()

        if (binding.title.text.toString().isEmpty() || binding.contactInfo.text.toString()
                .isEmpty() || binding.desc.text.toString().isEmpty() || imageUri == null
        ) {
            Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show()
        } else {
            uploadImage()
        }
    }

    private fun uploadImage() {
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Uploading Advert")
        progressDialog.setCancelable(false)
        progressDialog.show()

        val timeStamp = System.currentTimeMillis()
        val filePathAndName = "ad/$timeStamp"
        val storageReference = FirebaseStorage.getInstance().getReference(filePathAndName)
        storageReference.putFile(imageUri!!)
            .addOnSuccessListener { taskSnapShot ->
                val uriask: Task<Uri> = taskSnapShot.storage.downloadUrl
                while (!uriask.isSuccessful);
                val uploadedImageUrl = "${uriask.result}"

                uploadImageInfoToDb(uploadedImageUrl, timeStamp)

                progressDialog.dismiss()

            }
            .addOnFailureListener { e ->
                progressDialog.dismiss()
                Toast.makeText(
                    this,
                    "Uploading to Storage Failed due to ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }

    }

    private fun uploadImageInfoToDb(uploadedImageUrl: String, timeStamp: Long) {
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Uploading data")
        val uid = FirebaseAuth.getInstance().uid
        val hashMap: HashMap<String, Any> = HashMap()
        hashMap["uid"] = "$uid"
        hashMap["title"] = "$adTitle"
        hashMap["contact"] = "$adContact"
        hashMap["desc"] = "$adDesc"
        hashMap["imageUrl"] = "$uploadedImageUrl"

        val ref = FirebaseDatabase.getInstance().getReference("Adverts")
        ref.child("$timeStamp")
            .setValue(hashMap)
            .addOnSuccessListener {
                binding.title.text!!.clear()
                binding.contactInfo.text!!.clear()
                binding.desc.text!!.clear()
                progressDialog.dismiss()
                Toast.makeText(
                    this,
                    "Uploaded",
                    Toast.LENGTH_SHORT
                ).show()
                imageUri = null

            }
            .addOnFailureListener { e ->
                progressDialog.dismiss()
                Toast.makeText(
                    this,
                    "Uploading to Storage Failed due to ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()

            }

    }

}
