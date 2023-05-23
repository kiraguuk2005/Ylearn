package com.example.ylearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.ylearn.databinding.ActivityHumanBinding

class Human : AppCompatActivity() {

    private lateinit var binding: ActivityHumanBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHumanBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        navController= Navigation.findNavController(this,R.id.activity_main_nav_host_fragment)
        setupWithNavController(binding.bottomNavigationView,navController)
    }
}