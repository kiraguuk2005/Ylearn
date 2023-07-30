package com.example.ylearn

import android.app.ProgressDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.TextUtils
import android.view.LayoutInflater
import android.widget.MediaController
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.ylearn.databinding.ActivityMyVideosBinding
import com.example.ylearn.databinding.ListItemDialogBinding
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage

class MyVideos : AppCompatActivity() {

    private lateinit var binding: ActivityMyVideosBinding
    private val VIDEO_PICK_GALLERY_CODE = 100
    private val VIDEO_PICK_CAMERA_CODE = 101
    private val CAMERA_REQUEST_CODE = 102

    private lateinit var cameraPermissions: Array<String>
    private var videoUri: Uri? = null

    private lateinit var progressDialog: ProgressDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMyVideosBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        cameraPermissions = arrayOf(
            android.Manifest.permission.CAMERA,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        )

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please Wait...")
        progressDialog.setMessage("Uploading Video...")
        progressDialog.setCanceledOnTouchOutside(false)

        binding.btnUploadVideo.setOnClickListener {
            val title = binding.videoTitle.text.toString().trim()
            if (TextUtils.isEmpty(title)) {
                Toast.makeText(this, "Title Required", Toast.LENGTH_SHORT).show()
            } else if (videoUri == null) {
                Toast.makeText(this, "Pick Video", Toast.LENGTH_SHORT).show()
            } else {
                uploadVideoToFireBase()
            }
        }

        binding.pickVideoFab.setOnClickListener {
            videoPickDialog()
        }

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun uploadVideoToFireBase() {
        progressDialog.show()
        val timeStamp = "" + System.currentTimeMillis()
        val filePathAndName = "Videos/video_$timeStamp"
        val storageReference = FirebaseStorage.getInstance().getReference(filePathAndName)
        storageReference.putFile(videoUri!!)
            .addOnSuccessListener { taskSnapshot ->
                val uriTask = taskSnapshot.storage.downloadUrl
                while (!uriTask.isSuccessful);
                val downloadUri = uriTask.result
                if (uriTask.isSuccessful) {
                    val hashMap = HashMap<String, Any>()
                    hashMap["id"] = "$timeStamp"
                    hashMap["title"] = "$title"
                    hashMap["timestamp"] = "$timeStamp"
                    hashMap["videoUri"] = "$downloadUri"

                    val ref = FirebaseDatabase.getInstance().getReference("videos")
                    ref.child("$timeStamp")
                        .setValue(hashMap)
                        .addOnSuccessListener { taskSnapshot ->
                            progressDialog.dismiss()
                            Toast.makeText(this, "Video Uploaded", Toast.LENGTH_SHORT).show()
                        }
                        .addOnFailureListener { e ->
                            progressDialog.dismiss()
                            Toast.makeText(this, "${e.message}", Toast.LENGTH_SHORT).show()
                        }
                }
            }
            .addOnFailureListener { e ->
                progressDialog.dismiss()
                Toast.makeText(this, "${e.message}", Toast.LENGTH_SHORT).show()
            }

    }

    private fun videoPickDialog() {
        val options = arrayOf<CharSequence>("Camera", "Gallery")
        val dialogBinding = ListItemDialogBinding.inflate(LayoutInflater.from(this))
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Pick Video From")
            .setView(dialogBinding.root)
            .setItems(options) { _, i ->
                if (i == 0) {
                    if (!checkCameraPermission()) {
                        requestCameraPermissions()
                    } else {
                        videoPickCamera()
                    }
                } else {
                    videoPickGallery()
                }

            }
        builder.show()
    }

    private fun requestCameraPermissions() {
        ActivityCompat.requestPermissions(
            this,
            cameraPermissions,
            CAMERA_REQUEST_CODE
        )
    }

    private fun checkCameraPermission(): Boolean {
        val result1 = ContextCompat.checkSelfPermission(
            this,
            android.Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED

        val result2 = ContextCompat.checkSelfPermission(
            this,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED

        return result1 && result2
    }

    private fun videoPickGallery() {
        val intent = Intent()
        intent.type = "video/*"
        intent.action = Intent.ACTION_GET_CONTENT

        startActivityForResult(
            Intent.createChooser(intent, "Choose Video"),
            VIDEO_PICK_GALLERY_CODE
        )
    }

    private fun videoPickCamera() {
        val intent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
        startActivityForResult(intent, VIDEO_PICK_CAMERA_CODE)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            CAMERA_REQUEST_CODE ->
                if (grantResults.size > 0) {
                    val cameraAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED
                    val storageAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED
                    if (cameraAccepted && storageAccepted) {
                        videoPickCamera()
                    } else {
                        Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
                    }

                }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (resultCode == RESULT_OK) {
            if (requestCode == VIDEO_PICK_CAMERA_CODE) {
                videoUri = data!!.data
                setVideoToVideoView()
            } else if (requestCode == VIDEO_PICK_GALLERY_CODE) {
                videoUri = data!!.data
                setVideoToVideoView()
            }
        } else {
            Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show()
        }

        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun setVideoToVideoView() {
        val mediaController = MediaController(this)
        mediaController.setAnchorView(binding.videoView)
        binding.videoView.setMediaController(mediaController)
        binding.videoView.setVideoURI(videoUri)
        binding.videoView.requestFocus()
        binding.videoView.setOnPreparedListener {
            binding.videoView.pause()
        }
    }
}