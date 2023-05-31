package com.example.ylearn

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.ylearn.adapter.ViewPagerAdapter
import com.example.ylearn.databinding.ActivityHomeBinding
import com.example.ylearn.fragments.AiFragment
import com.example.ylearn.fragments.QuestionsFragment
import com.example.ylearn.fragments.SearchFragment
import com.example.ylearn.fragments.VideoFragment

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivProfileImage.setOnClickListener {
            startActivity(Intent(this, UserProfile::class.java))
        }

        binding.ivNotifications.setOnClickListener {
            startActivity(Intent(this, Notifications::class.java))
        }

        setUpTabs()


    }
    private fun setUpTabs(){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(QuestionsFragment(), "Questions")
        adapter.addFragment(SearchFragment(), "Search")
        adapter.addFragment(AiFragment(), "Ai")
        adapter.addFragment(VideoFragment(), "Videos")
        binding.viewPager.adapter = adapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }


}