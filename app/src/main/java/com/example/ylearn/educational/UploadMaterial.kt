package com.example.ylearn.educational

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.ylearn.databinding.ActivityUploadMaterialBinding
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage

class UploadMaterial : AppCompatActivity() {

    private lateinit var binding: ActivityUploadMaterialBinding

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var progressDialog: ProgressDialog
    private var pdfUri: Uri? = null
    private val TAG = "PDF ADD TAG"


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityUploadMaterialBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }

        firebaseAuth = FirebaseAuth.getInstance()

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please Wait")
        progressDialog.setCanceledOnTouchOutside(false)

        binding.pickPdf.setOnClickListener {
            pickPdfIntent()
        }

        binding.btnUploadPdf.setOnClickListener {
            validateData()
        }
    }

    private var title = ""
    private var support = ""
    private var description = ""
    private fun validateData() {
        Log.d(TAG, "Validating Data")
        title = binding.pdfTitle.text.toString().trim()
        support = binding.pdfSupport.text.toString().trim()
        description = binding.pdfDescription.text.toString().trim()

        if (title.isEmpty()) {
            Toast.makeText(this, "Enter Title", Toast.LENGTH_SHORT).show()
        } else if (support.isEmpty()) {
            Toast.makeText(this, "Enter Support", Toast.LENGTH_SHORT).show()
        } else if (description.isEmpty()) {
            Toast.makeText(this, "Enter Youtube", Toast.LENGTH_SHORT).show()
        } else {
            uploadPdfToStorage()
            binding.pdfTitle.text?.clear()
            binding.pdfSupport.text?.clear()
            binding.pdfDescription.text?.clear()
        }
    }

    private fun uploadPdfToStorage() {
        Log.d(TAG, "Uploading to storage")

        progressDialog.setMessage("Uploading PDF")
        progressDialog.show()

        val timeStamp = System.currentTimeMillis()
        val filePathAndName = "PDF/$timeStamp"
        val storageReference = FirebaseStorage.getInstance().getReference(filePathAndName)
        storageReference.putFile(pdfUri!!)
            .addOnSuccessListener { taskSnapShot ->
                Log.d(TAG, "Uploading to Storage")
                val uriask: Task<Uri> = taskSnapShot.storage.downloadUrl
                while (!uriask.isSuccessful);
                val uploadedPdfUrl = "${uriask.result}"

                uploadPdfInfoToDb(uploadedPdfUrl, timeStamp)

            }
            .addOnFailureListener { e ->
                Log.d(TAG, "Uploading to Storage Failed due to ${e.message}")
                progressDialog.dismiss()
                Toast.makeText(
                    this,
                    "Uploading to Storage Failed due to ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }

    private fun uploadPdfInfoToDb(uploadedPdfUrl: String, timeStamp: Long) {
        Log.d(TAG, "Uploading to Database")
        progressDialog.setMessage("Uploading data")
        val uid = FirebaseAuth.getInstance().uid
        val hashMap: HashMap<String, Any> = HashMap()

        hashMap["uid"] = "$uid"
//        hashMap["id"] = "$timeStamp"
        hashMap["title"] = "$title"
        hashMap["support"] = "$support"
        hashMap["description"] = "$description"
        hashMap["url"] = "$uploadedPdfUrl"
//        hashMap["timestamp"] = timeStamp
//        hashMap["viewCount"] = 0
//        hashMap["downloadCount"] = 0

        val ref = FirebaseDatabase.getInstance().getReference("Books")
        ref.child("$timeStamp")
            .setValue(hashMap)
            .addOnSuccessListener {
                Log.d(TAG, "Uploaded")
                progressDialog.dismiss()
                Toast.makeText(
                    this,
                    "Uploaded",
                    Toast.LENGTH_SHORT
                ).show()
                pdfUri = null

            }
            .addOnFailureListener { e ->
                Log.d(TAG, "Uploading to Storage Failed due to ${e.message}")
                progressDialog.dismiss()
                Toast.makeText(
                    this,
                    "Uploading to Storage Failed due to ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()

            }


    }

    private fun pickPdfIntent() {
        Log.d(TAG, "Starting pdf picking Intent")
        val intent = Intent()
        intent.type = "application/pdf"
        intent.action = Intent.ACTION_GET_CONTENT
        pdfActivityResultLauncher.launch(intent)
    }

    val pdfActivityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
        ActivityResultCallback<ActivityResult> { result ->
            if (result.resultCode == RESULT_OK) {
                Log.d(TAG, "PDF Picked")
                pdfUri = result.data!!.data
            } else {
                Log.d(TAG, "PDF Picking Cancelled")
                Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show()
            }

        }

    )
}