package com.example.ylearn.bookfragment

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.ylearn.R
import com.example.ylearn.databinding.FragmentUploadBookBinding
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage

class UploadBookFragment : Fragment() {
    private var _binding: FragmentUploadBookBinding? = null
    private val binding get() = _binding!!

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var progressDialog: ProgressDialog
    private var bookUri: Uri? = null
    private val TAG = "BOOK ADD TAG"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUploadBookBinding.inflate(inflater, container, false)

        val bookCategory = resources.getStringArray(R.array.bookCategory)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.list_item, bookCategory)
        binding.bookCategory.setAdapter(arrayAdapter)


        val bookLevel = resources.getStringArray(R.array.bookLevel)
        val arrayAdapter2 = ArrayAdapter(requireContext(), R.layout.list_item, bookLevel)
        binding.bookLevel.setAdapter(arrayAdapter2)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firebaseAuth = FirebaseAuth.getInstance()

        progressDialog = ProgressDialog(requireActivity())
        progressDialog.setTitle("Please Wait")
        progressDialog.setCanceledOnTouchOutside(false)

        binding.pickBook.setOnClickListener {
            pickPdfIntent()
        }
        binding.btnBookUpload.setOnClickListener {
            validateData()
        }
    }


    private var bookTitle = ""
    private var bookCategory = ""
    private var bookLevel = ""
    private var bookPrice = ""
    private var bookDescription = ""
    private fun validateData() {
        Log.d(TAG, "Validating Data")
        bookTitle = binding.bookTitle.text.toString().trim()
        bookCategory = binding.bookCategory.text.toString().trim()
        bookLevel = binding.bookLevel.text.toString().trim()
        bookPrice = binding.bookPrice.text.toString().trim()
        bookDescription = binding.bookDescription.text.toString().trim()

        if (bookTitle.isEmpty()) {
            Toast.makeText(requireActivity(), "Enter Book Title", Toast.LENGTH_SHORT).show()
        } else if (bookCategory.isEmpty()) {
            Toast.makeText(requireActivity(), "Choose Book Category", Toast.LENGTH_SHORT).show()
        } else if (bookLevel.isEmpty()) {
            Toast.makeText(requireActivity(), "Choose Book Level", Toast.LENGTH_SHORT).show()
        } else if (bookPrice.isEmpty()){
            Toast.makeText(requireActivity(), "Enter Book Price", Toast.LENGTH_SHORT).show()
        }else if (bookDescription.isEmpty()){
            Toast.makeText(requireActivity(), "Enter Book Description", Toast.LENGTH_SHORT).show()
        } else {
            uploadPdfToStorage()
            binding.bookTitle.text?.clear()
            binding.bookCategory.text?.clear()
            binding.bookLevel.text?.clear()
            binding.bookPrice.text?.clear()
            binding.bookDescription.text?.clear()
        }

    }

    private fun uploadPdfToStorage() {
        Log.d(TAG, "Uploading to storage")

        progressDialog.setMessage("Uploading Book")
        progressDialog.show()

        val timeStamp = System.currentTimeMillis()
        val filePathAndName = "PDF/$timeStamp"
        val storageReference = FirebaseStorage.getInstance().getReference(filePathAndName)
        storageReference.putFile(bookUri!!)
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
                    requireActivity(),
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
        hashMap["title"] = "$bookTitle"
        hashMap["bookCategory"] = "$bookCategory"
        hashMap["bookLevel"] = "$bookLevel"
        hashMap["bookPrice"] = "$bookPrice"
        hashMap["bookDescription"] = "$bookDescription"
        hashMap["url"] = "$uploadedPdfUrl"

        val ref = FirebaseDatabase.getInstance().getReference("books")
        ref.child("$timeStamp")
            .setValue(hashMap)
            .addOnSuccessListener {
                Log.d(TAG, "Uploaded")
                progressDialog.dismiss()
                Toast.makeText(
                    requireActivity(),
                    "Uploaded",
                    Toast.LENGTH_SHORT
                ).show()
                bookUri = null

            }
            .addOnFailureListener { e ->
                Log.d(TAG, "Uploading to Storage Failed due to ${e.message}")
                progressDialog.dismiss()
                Toast.makeText(
                    requireActivity(),
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
            if (result.resultCode == AppCompatActivity.RESULT_OK) {
                Log.d(TAG, "PDF Picked")
                bookUri = result.data!!.data
            } else {
                Log.d(TAG, "PDF Picking Cancelled")
                Toast.makeText(requireActivity(), "Cancelled", Toast.LENGTH_SHORT).show()
            }

        }

    )

}

