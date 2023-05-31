package com.example.ylearn.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ylearn.databinding.NotificationItemBinding
import com.example.ylearn.model.NotificationData

class NotificationsAdapter(private val list: ArrayList<NotificationData>): RecyclerView.Adapter<NotificationsAdapter.NotificationView>() {

    inner class NotificationView(val notificationItemBinding: NotificationItemBinding): RecyclerView.ViewHolder(notificationItemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationView {
        return NotificationView(NotificationItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: NotificationView, position: Int) {
       holder.notificationItemBinding.imageView.setImageResource(list[position].image)
        holder.notificationItemBinding.tvUserName.text = list[position].userName
        holder.notificationItemBinding.tvContent.text = list[position].message
    }

    override fun getItemCount(): Int {
        return list.size
    }


}