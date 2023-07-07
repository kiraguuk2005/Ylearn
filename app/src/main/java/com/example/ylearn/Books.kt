package com.example.ylearn


import android.media.VolumeShaper
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
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
        if (resources.getColor(R.color.background_tint_dark) == resources.getColor(R.color.background_tint_dark) ) {
            binding.bottomNavigationView.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.background_tint_dark
                )
            )
        } else {
            binding.bottomNavigationView.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.background_tint_light
                )
            )
        }


    }


    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }


}