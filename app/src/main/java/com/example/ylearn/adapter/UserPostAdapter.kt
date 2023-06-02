package com.example.ylearn.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ylearn.databinding.PostItemBinding
import com.example.ylearn.model.PostData

class UserPostAdapter(private val list: ArrayList<PostData>) : RecyclerView.Adapter<UserPostAdapter.UserPostView>() {

    inner class UserPostView(val postItemBinding: PostItemBinding ) : RecyclerView.ViewHolder(postItemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserPostView {
        return UserPostView(PostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: UserPostView, position: Int) {
        holder.postItemBinding.tvViews.text = list[position].views
        holder.postItemBinding.ivVideo.setImageResource(list[position].image)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}