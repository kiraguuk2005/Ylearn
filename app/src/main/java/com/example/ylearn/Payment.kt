package com.example.ylearn

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ylearn.databinding.ActivityPaymentBinding

class Payment : AppCompatActivity() {
    private lateinit var binding: ActivityPaymentBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            intent

            tvTitle.text = intent.getStringExtra("title")
            tvPrice.text = intent.getStringExtra("price")
        }

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.rbMpesa -> Toast.makeText(this@Payment, "Mpesa", Toast.LENGTH_SHORT).show()
                R.id.rbPaypal -> Toast.makeText(this@Payment, "PayPal", Toast.LENGTH_SHORT).show()
                R.id.rbMaster -> Toast.makeText(this@Payment, "Master", Toast.LENGTH_SHORT).show()
            }
        }


    }

}