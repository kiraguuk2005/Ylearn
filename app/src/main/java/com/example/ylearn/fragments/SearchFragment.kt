package com.example.ylearn.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ylearn.FloatingForm
import com.example.ylearn.PictorialQuestionDescription
import com.example.ylearn.PostPictorialQuestion
import com.example.ylearn.R
import com.example.ylearn.adapter.PictorialAdapter
import com.example.ylearn.databinding.FragmentSearchBinding
import com.example.ylearn.model.PictorialquizData
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class SearchFragment : Fragment(), PictorialAdapter.onQuizClickListener {
    private lateinit var binding: FragmentSearchBinding

    private lateinit var adapter: PictorialAdapter
    private lateinit var recyclerView: RecyclerView
    private var quizArrayList = mutableListOf<PictorialquizData>()

    private lateinit var database: DatabaseReference


//    val REQUEST_IMAGE_CAPTURE = 1
//    private var imageUri: Uri? = null
//    private val selectImage = registerForActivityResult(ActivityResultContracts.GetContent()) {
//        imageUri = it
//        binding.imageHolder.setImageURI(imageUri)
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getJobs()

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.imageQuizRecycler)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = PictorialAdapter(quizArrayList, this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()


        binding.postQuestion.setOnClickListener {
            val intent = Intent(requireActivity(), PostPictorialQuestion::class.java)
            startActivity(intent)
        }
//
//        binding.imageHolder.setOnClickListener {
////            val intent = Intent()
////            intent.action = Intent.ACTION_GET_CONTENT
////            intent.type = "image/*"
////            startActivityForResult(intent, 1)
//            selectImage.launch("image/*")
//        }
//
//        binding.btnPost.setOnClickListener {
//            validateData()
//        }


    }

    override fun onQuizClick(quiz: PictorialquizData, position: Int) {
        val intent = Intent(requireActivity(), PictorialQuestionDescription::class.java)
        intent.putExtra("image", quiz.imageUrl.toString())
        intent.putExtra("quizTitle", quiz.quizTitle)
        intent.putExtra("quizDescription", quiz.quizDescription)
        startActivity(intent)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun getJobs() {
        database = Firebase.database.reference
        database.child("ImageQuestions").get()
            .addOnSuccessListener { dataSnapshot ->
                for (jobSnapshot in dataSnapshot.children) {
                    val id = jobSnapshot.child("id").getValue(String::class.java)
                    val imageUrl = jobSnapshot.child("imageUrl").getValue(String::class.java)
                    val quizTitle = jobSnapshot.child("quizTitle").getValue(String::class.java)
                    val quizDescription =
                        jobSnapshot.child("quizDescription").getValue(String::class.java)
                    val uid = jobSnapshot.child("uid").getValue(String::class.java)

                    if (id != null && imageUrl != null && quizTitle != null && quizDescription != null && uid != null) {
                        val quiz = PictorialquizData(id, imageUrl, quizTitle, quizDescription)
                        quizArrayList.add(quiz)
                    }
                }
                adapter.notifyDataSetChanged()

            }
    }
}

//    private var quizDesc = ""
//    private var quizImage = ""
//    private fun validateData() {
//        quizDesc = binding.quizDescription.text.toString()
//        quizImage = binding.imageHolder.toString().trim()
//        if (binding.quizDescription.text.toString().isEmpty() || imageUri == null
//        ) {
//            Toast.makeText(requireActivity(), "Fill all fields", Toast.LENGTH_SHORT).show()
//        } else {
//            uploadImage()
//        }
//
//    }
//
//    private fun uploadImage() {
//        val progressDialog = ProgressDialog(requireActivity())
//        progressDialog.setMessage("Uploading Question")
//        progressDialog.setCancelable(false)
//        progressDialog.show()
//
//        val timeStamp = System.currentTimeMillis()
//        val filePathAndName = "quiz/$timeStamp"
//        val storageReference = FirebaseStorage.getInstance().getReference(filePathAndName)
//        storageReference.putFile(imageUri!!)
//            .addOnSuccessListener { taskSnapShot ->
//                val uriask: Task<Uri> = taskSnapShot.storage.downloadUrl
//                while (!uriask.isSuccessful);
//                val uploadedImageUrl = "${uriask.result}"
//
//                uploadImageInfoToDb(uploadedImageUrl, timeStamp)
//
//                progressDialog.dismiss()
//
//            }
//            .addOnFailureListener { e ->
//                progressDialog.dismiss()
//                Toast.makeText(
//                    requireActivity(),
//                    "Uploading to Storage Failed due to ${e.message}",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//    }
//
//    private fun uploadImageInfoToDb(uploadedImageUrl: String, timeStamp: Long) {
//
//        val progressDialog = ProgressDialog(requireActivity())
//        progressDialog.setMessage("Uploading data")
//        val uid = FirebaseAuth.getInstance().uid
//        val hashMap: HashMap<String, Any> = HashMap()
//        hashMap["uid"] = "$uid"
//        hashMap["desc"] = "$quizDesc"
//        hashMap["imageUrl"] = "$uploadedImageUrl"
//
//        val ref = FirebaseDatabase.getInstance().getReference("ImageQuestions")
//        ref.child("$timeStamp")
//            .setValue(hashMap)
//            .addOnSuccessListener {
//
//                binding.quizDescription.text!!.clear()
//                progressDialog.dismiss()
//                Toast.makeText(
//                    requireActivity(),
//                    "Uploaded",
//                    Toast.LENGTH_SHORT
//                ).show()
//                imageUri = null
//
//            }
//            .addOnFailureListener { e ->
//                progressDialog.dismiss()
//                Toast.makeText(
//                    requireActivity(),
//                    "Uploading to Storage Failed due to ${e.message}",
//                    Toast.LENGTH_SHORT
//                ).show()
//
//            }
//
//
//    }
//
//
//    private fun dispatchTakePictureIntent() {
//        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//        try {
//            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
//        } catch (e: ActivityNotFoundException) {
//            // display error state to the user
//            Toast.makeText(requireActivity(), "Failed to Work", Toast.LENGTH_SHORT).show()
//        }
//
//    }
//
//    @Deprecated("Deprecated in Java")
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == AppCompatActivity.RESULT_OK) {
//            val imageBitmap = data?.extras?.get("data") as Bitmap
//            binding.imageHolder.setImageBitmap(imageBitmap)
//        }
//    }




