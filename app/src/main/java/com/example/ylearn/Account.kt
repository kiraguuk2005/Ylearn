package com.example.ylearn

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import com.example.ylearn.databinding.ActivityAccountBinding

class Account : AppCompatActivity() {

    private lateinit var binding: ActivityAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding  =ActivityAccountBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivPass.setOnClickListener {
            showDialog()
        }

        binding.ivBack.setOnClickListener {
            startActivity(Intent(this, Settings::class.java))
        }

        binding.ivAccInfo.setOnClickListener {
            showDialogInfo()
        }
    }

    private fun showDialog(){
        var dialog  = Dialog(this@Account)
        dialog.requestWindowFeature(
            Window.FEATURE_NO_TITLE
        )
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.setting_dialog)
        dialog.window!!.attributes.windowAnimations = R.style.dialogAnimation
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        var btnCancel = dialog.findViewById(R.id.btnCancel) as TextView
        dialog.window!!.setGravity(Gravity.BOTTOM)

        btnCancel.setOnClickListener {
            dialog.dismiss()
        }
        showDialog()
    }

    private fun showDialogInfo() {
        var dialog = Dialog(this@Account)
        dialog.requestWindowFeature(
            Window.FEATURE_NO_TITLE
        )
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.setting_dialog)
        dialog.window!!.attributes.windowAnimations = R.style.dialogAnimation
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        var ivCancel = dialog.findViewById(R.id.ivClose) as ImageView
        dialog.window!!.setGravity(Gravity.BOTTOM)

        ivCancel.setOnClickListener {
            dialog.dismiss()
        }
        showDialogInfo()
    }
}