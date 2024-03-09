package com.example.ylearn

import android.app.ProgressDialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.ylearn.databinding.ActivityPostPictorialQuestionBinding
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage

class PostPictorialQuestion : AppCompatActivity() {
    private lateinit var binding: ActivityPostPictorialQuestionBinding

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var progressDialog: ProgressDialog
//    private var quizUri: Uri? = null
//    private val TAG = "QUIZ ADD TAG"

    val REQUEST_IMAGE_CAPTURE = 1
    private var imageUri: Uri? = null
    private val selectImage = registerForActivityResult(ActivityResultContracts.GetContent()) {
        imageUri = it
        binding.imageHolder.setImageURI(imageUri)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPostPictorialQuestionBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.takeImage.setOnClickListener {
            dispatchTakePictureIntent()
        }

        binding.imageHolder.setOnClickListener {
//            val intent = Intent()
//            intent.action = Intent.ACTION_GET_CONTENT
//            intent.type = "image/*"
//            startActivityForResult(intent, 1)
            selectImage.launch("image/*")
        }

        binding.btnPost.setOnClickListener {
            validateData()
        }


    }

    private var quizTitle = ""
    private var quizDescription = ""
    private fun validateData() {
        quizTitle = binding.quizTitle.text.toString()
        quizDescription = binding.quizDescription.toString().trim()
        if (binding.quizTitle.text.toString().isEmpty() || imageUri == null || binding.quizDescription.text.toString().isEmpty()
        ) {
            Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show()
        } else {
            uploadImage()
        }

    }

    private fun uploadImage() {
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Uploading Question")
        progressDialog.setCancelable(false)
        progressDialog.show()

        val timeStamp = System.currentTimeMillis()
        val filePathAndName = "quiz/$timeStamp"
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
        hashMap["id"] = "$timeStamp"
        hashMap["uid"] = "$uid"
        hashMap["desc"] = "$quizTitle"
        hashMap["desc"] = "$quizDescription"
        hashMap["imageUrl"] = "$uploadedImageUrl"

        val ref = FirebaseDatabase.getInstance().getReference("ImageQuestions")
        ref.child("$timeStamp")
            .setValue(hashMap)
            .addOnSuccessListener {

                binding.quizDescription.text!!.clear()
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


    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        } catch (e: ActivityNotFoundException) {
            // display error state to the user
            Toast.makeText(this, "Failed to Work", Toast.LENGTH_SHORT).show()
        }

    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == AppCompatActivity.RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            binding.imageHolder.setImageBitmap(imageBitmap)
        }
    }

}