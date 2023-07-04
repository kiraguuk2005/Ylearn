package com.example.ylearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ylearn.adapter.ViewPagerAdapter
import com.example.ylearn.databinding.ActivityEarnBinding
import com.example.ylearn.earnFragments.ImageFragment
import com.example.ylearn.earnFragments.TextFragment
import com.example.ylearn.fragments.AiFragment
import com.example.ylearn.fragments.QuestionsFragment
import com.example.ylearn.fragments.SearchFragment
import com.example.ylearn.fragments.VideoFragment

class Earn : AppCompatActivity() {
    private lateinit var binding: ActivityEarnBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEarnBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }

        setUpTabs()
    }

    private fun setUpTabs(){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(TextFragment(), "Text")
        adapter.addFragment(ImageFragment(), "Images")
        adapter.addFragment(VideoFragment(), "Videos")
        binding.viewPager.adapter = adapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
}