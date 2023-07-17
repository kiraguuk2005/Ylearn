package com.example.ylearn.educational.sharedClass

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ylearn.adapter.EducationMaterialsAdapter
import com.example.ylearn.databinding.ActivityStudyMaterialsBinding
import com.example.ylearn.educational.educationalFragments.ReadersFragment
import com.example.ylearn.fragments.VideoFragment

class StudyMaterials : AppCompatActivity() {
    private lateinit var binding: ActivityStudyMaterialsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityStudyMaterialsBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setUpTabs()

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setUpTabs() {
        val adapter = EducationMaterialsAdapter(supportFragmentManager)
        adapter.addFragment(ReadersFragment(), "Books(PDF)")
        adapter.addFragment(VideoFragment(), "Videos")
        binding.viewPager.adapter = adapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
}