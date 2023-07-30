package com.example.ylearn

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ylearn.databinding.ActivityClickRecylerBookBinding
import com.example.ylearn.model.booksModel.BooksData

class ClickRecyclerBook : AppCompatActivity() {
    private lateinit var binding: ActivityClickRecylerBookBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityClickRecylerBookBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            intent

            tvTitle.text = intent.getStringExtra("title")
            tvContent.text = intent.getStringExtra("content")
            tvPrice.text = intent.getStringExtra("price")
        }

        binding.btnBuy.setOnClickListener {
            val intent = Intent(this, Payment::class.java)
            intent.putExtra("title", binding.tvTitle.text.toString())
            intent.putExtra("price", binding.tvPrice.text.toString())
            startActivity(intent)
        }

    }


}