package com.example.ylearn

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ylearn.adapter.ImagesAdapter
import com.example.ylearn.databinding.ActivityChoiceBinding
import com.example.ylearn.model.advert.AdData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Choice : AppCompatActivity() {

    private lateinit var binding: ActivityChoiceBinding
    private lateinit var auth: FirebaseAuth

//    private lateinit var adapter: ImagesAdapter
//    private lateinit var recyclerView: RecyclerView
//    private lateinit var adArrayList: ArrayList<AdData>
//
//    //read ads,
//    var database = FirebaseDatabase.getInstance()
//    val adReference = database.getReference("Adverts")


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityChoiceBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

//        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//        recyclerView = binding.recyclerView
//        recyclerView.layoutManager = layoutManager
//        recyclerView.setHasFixedSize(true)
//        adapter = ImagesAdapter(adArrayList)
//        recyclerView.adapter = adapter
//        adapter.notifyDataSetChanged()
//
//        getData("ads")


        binding.btnHome.setOnClickListener {
            startActivity(Intent(this, Home::class.java))
        }

        binding.btnAi.setOnClickListener {
            startActivity(Intent(this, Ai::class.java))

        }
        binding.btnEarn.setOnClickListener {
            startActivity(Intent(this, EducationMaterials::class.java))

        }
        binding.btnbooks.setOnClickListener {
            startActivity(Intent(this, Books::class.java))
        }

        binding.btnLogout.setOnClickListener {
            logOut()
        }

        binding.btnAdvert.setOnClickListener {
            startActivity(Intent(this, Advertise::class.java))
        }
    }
//
//    private fun getData(ads: String?) {
//        adReference.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                var adsArrayList = ArrayList<AdData>()
//                for (childSnapshot in dataSnapshot.children) {
//                    val advert = childSnapshot.getValue(AdData::class.java)
//                    advert?.let { adsArrayList.add(it) }
//                }
//                adapter = ImagesAdapter(adArrayList)
//                recyclerView.adapter = adapter
//                adapter.notifyDataSetChanged()
//
//            }
//
//            override fun onCancelled(databaseError: DatabaseError) {
//                // Handle the error
//            }
//        })
//
//    }

    private fun logOut() {
        auth.signOut()
        startActivity(Intent(this, Login::class.java))
        finish()
    }
}


