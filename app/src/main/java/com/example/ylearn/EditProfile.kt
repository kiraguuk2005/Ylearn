package com.example.ylearn

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.widget.TextView
import com.example.ylearn.databinding.ActivityEditProfileBinding

class EditProfile : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivEditUserName.setOnClickListener {
            showDialog()
        }

        binding.ivEditBio.setOnClickListener {
            showDialog2()
        }
    }

    private fun showDialog(){
        var dialog  = Dialog(this@EditProfile)
        dialog.requestWindowFeature(
            Window.FEATURE_NO_TITLE
        )
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.setting_dialog)
        dialog.window!!.attributes.windowAnimations = R.style.dialogAnimation
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        var btnCancel = dialog.findViewById(R.id.btnCancel2) as TextView
        dialog.window!!.setGravity(Gravity.BOTTOM)

        btnCancel.setOnClickListener {
            dialog.dismiss()
        }
        showDialog()
    }

    private fun showDialog2(){
        var dialog  = Dialog(this@EditProfile)
        dialog.requestWindowFeature(
            Window.FEATURE_NO_TITLE
        )
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.setting_dialog)
        dialog.window!!.attributes.windowAnimations = R.style.dialogAnimation
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        var btnCancel = dialog.findViewById(R.id.btnCancel2) as TextView
        dialog.window!!.setGravity(Gravity.BOTTOM)

        btnCancel.setOnClickListener {
            dialog.dismiss()
        }
        showDialog2()
    }
}