package com.example.ylearn

import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.ylearn.bookfragment.BooksFragment
import com.example.ylearn.bookfragment.UploadBookFragment
import com.example.ylearn.databinding.ActivityBooksBinding

class Books : AppCompatActivity() {
    private lateinit var binding: ActivityBooksBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityBooksBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        replaceFragment(BooksFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.icBooks -> replaceFragment(BooksFragment())
                R.id.icPDF -> replaceFragment(UploadBookFragment())

                else -> {
                }
            }
            true
        }

//        binding.btnRead.setOnClickListener {
//            launcher.launch("application/pdf")
//        }

    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }

//    private val launcher = registerForActivityResult(ActivityResultContracts.GetContent()){
//            uri ->
//        uri?.let {
//            binding.pdfView.fromUri(it).load()
//        }
//    }
}