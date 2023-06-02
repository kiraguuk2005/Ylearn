package com.example.ylearn

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ylearn.adapter.UserPostAdapter
import com.example.ylearn.databinding.ActivityUserProfileBinding
import com.example.ylearn.model.PostData

class UserProfile : AppCompatActivity() {

    private lateinit var binding: ActivityUserProfileBinding
    private lateinit var userPostAdapter: UserPostAdapter
    private lateinit var list: ArrayList<PostData>

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityUserProfileBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.editProfile.setOnClickListener {
            startActivity(
                Intent(this, EditProfile::class.java)
            )
        }

        binding.ivSettings.setOnClickListener {
            startActivity(
                Intent(this, Settings::class.java)
            )
        }

        binding.ivBack.setOnClickListener {
            startActivity(
                Intent(this, Home::class.java)
            )
        }

        userPostAdapter = UserPostAdapter(list)
        binding.userPostRecyclerView.adapter = userPostAdapter
        binding.userPostRecyclerView.layoutManager = GridLayoutManager(this, 2)


        list = ArrayList()
        list.add(PostData(R.drawable.user, "11 k"))
        list.add(PostData(R.drawable.bgd, "11 k"))
        list.add(PostData(R.drawable.user, "11 k"))
        list.add(PostData(R.drawable.bgd, "11 k"))
        list.add(PostData(R.drawable.user, "11 k"))
        list.add(PostData(R.drawable.bgd, "11 k"))
        list.add(PostData(R.drawable.user, "11 k"))
        list.add(PostData(R.drawable.bgd, "11 k"))
        list.add(PostData(R.drawable.user, "11 k"))
        list.add(PostData(R.drawable.bgd, "11 k"))
        list.add(PostData(R.drawable.user, "11 k"))
        list.add(PostData(R.drawable.user, "11 k"))
        list.add(PostData(R.drawable.user, "11 k"))
        list.add(PostData(R.drawable.user, "11 k"))
        list.add(PostData(R.drawable.user, "11 k"))
        list.add(PostData(R.drawable.user, "11 k"))
        list.add(PostData(R.drawable.user, "11 k"))


    }
}