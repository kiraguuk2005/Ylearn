package com.example.ylearn

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ylearn.databinding.ActivityAccountBinding

class Account : AppCompatActivity() {

    private lateinit var binding: ActivityAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityAccountBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivPass.setOnClickListener {
            startActivity(Intent(this, PasswordSetting::class.java))
        }

        binding.ivBack.setOnClickListener {
            startActivity(Intent(this, Settings::class.java))
        }

        binding.ivAccInfo.setOnClickListener {
            startActivity(Intent(this, AccountInfo::class.java))
        }
    }
//
//    private fun showDialog(){
//        val dialog  = Dialog(this@Account)
//        dialog.requestWindowFeature(
//            Window.FEATURE_NO_TITLE
//        )
//        dialog.setCancelable(false)
//        dialog.setContentView(R.layout.setting_dialog)
//        dialog.window!!.attributes.windowAnimations = R.style.dialogAnimation
//        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//        val btnCancel = dialog.findViewById(R.id.btnCancel) as TextView
//        dialog.window!!.setGravity(Gravity.BOTTOM)
//
//        btnCancel.setOnClickListener {
//            dialog.dismiss()
//        }
//        showDialog()
//    }
//
//    private fun showDialogInfo() {
//        val dialog = Dialog(this@Account)
//        dialog.requestWindowFeature(
//            Window.FEATURE_NO_TITLE
//        )
//        dialog.setCancelable(false)
//        dialog.setContentView(R.layout.setting_dialog)
//        dialog.window!!.attributes.windowAnimations = R.style.dialogAnimation
//        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//        val ivCancel = dialog.findViewById(R.id.ivClose) as ImageView
//        dialog.window!!.setGravity(Gravity.BOTTOM)
//
//        ivCancel.setOnClickListener {
//            dialog.dismiss()
//        }
//        showDialogInfo()
//    }
}