package com.example.ylearn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ylearn.adapter.NotificationsAdapter
import com.example.ylearn.databinding.ActivityNotificatiosBinding
import com.example.ylearn.model.NotificationData

class Notifications : AppCompatActivity() {

    private lateinit var binding: ActivityNotificatiosBinding
    private lateinit var notificationsAdapter: NotificationsAdapter
    private lateinit var list: ArrayList<NotificationData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityNotificatiosBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.root)

        binding.notificationsRecyclerview.setHasFixedSize(true)

        list = ArrayList()
        list.add(NotificationData(R.drawable.user, "John Doe", "Lorem ipsum dolor sit amet, consectetur adipiscin Ut enim ad minim veniam"))
        list.add(NotificationData(R.drawable.user, "John Doe", "Lorem ipsum dolor sit amet, consectetur adipiscin Ut enim ad minim veniam"))
        list.add(NotificationData(R.drawable.user, "John Doe", "Lorem ipsum dolor sit amet, consectetur adipiscin Ut enim ad minim veniam"))
        list.add(NotificationData(R.drawable.user, "John Doe", "Lorem ipsum dolor sit amet, consectetur adipiscin Ut enim ad minim veniam"))
        list.add(NotificationData(R.drawable.user, "John Doe", "Lorem ipsum dolor sit amet, consectetur adipiscin Ut enim ad minim veniam"))
        list.add(NotificationData(R.drawable.user, "John Doe", "Lorem ipsum dolor sit amet, consectetur adipiscin Ut enim ad minim veniam"))
        list.add(NotificationData(R.drawable.user, "John Doe", "Lorem ipsum dolor sit amet, consectetur adipiscin Ut enim ad minim veniam"))
        list.add(NotificationData(R.drawable.user, "John Doe", "Lorem ipsum dolor sit amet, consectetur adipiscin Ut enim ad minim veniam"))
        list.add(NotificationData(R.drawable.user, "John Doe", "Lorem ipsum dolor sit amet, consectetur adipiscin Ut enim ad minim veniam"))
        list.add(NotificationData(R.drawable.user, "John Doe", "Lorem ipsum dolor sit amet, consectetur adipiscin Ut enim ad minim veniam"))
        list.add(NotificationData(R.drawable.user, "John Doe", "Lorem ipsum dolor sit amet, consectetur adipiscin Ut enim ad minim veniam"))
        list.add(NotificationData(R.drawable.user, "John Doe", "Lorem ipsum dolor sit amet, consectetur adipiscin Ut enim ad minim veniam"))
        list.add(NotificationData(R.drawable.user, "John Doe", "Lorem ipsum dolor sit amet, consectetur adipiscin Ut enim ad minim veniam"))
        list.add(NotificationData(R.drawable.user, "John Doe", "Lorem ipsum dolor sit amet, consectetur adipiscin Ut enim ad minim veniam"))
        list.add(NotificationData(R.drawable.user, "John Doe", "Lorem ipsum dolor sit amet, consectetur adipiscin Ut enim ad minim veniam"))
        list.add(NotificationData(R.drawable.user, "John Doe", "Lorem ipsum dolor sit amet, consectetur adipiscin Ut enim ad minim veniam"))
        list.add(NotificationData(R.drawable.user, "John Doe", "Lorem ipsum dolor sit amet, consectetur adipiscin Ut enim ad minim veniam"))
        list.add(NotificationData(R.drawable.user, "John Doe", "Lorem ipsum dolor sit amet, consectetur adipiscin Ut enim ad minim veniam"))


        notificationsAdapter = NotificationsAdapter(list)
        binding.notificationsRecyclerview.adapter = notificationsAdapter
        binding.notificationsRecyclerview.layoutManager = LinearLayoutManager(this)

        binding.ivBack.setOnClickListener {
            startActivity(Intent(this, Home::class.java))
        }
    }
}