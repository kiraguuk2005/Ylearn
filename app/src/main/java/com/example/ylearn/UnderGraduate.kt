package com.example.ylearn

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ylearn.adapter.ChatsAdapter
import com.example.ylearn.databinding.ActivityUnderGraduateBinding
import com.example.ylearn.model.chatModel.ChatModel
import com.example.ylearn.model.chatModel.Repository

class UnderGraduate : AppCompatActivity() {
    private lateinit var binding: ActivityUnderGraduateBinding
    private var chats = arrayListOf<ChatModel>()
    private lateinit var chatsAdapter: ChatsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityUnderGraduateBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        chats = Repository().getChats()
        chatsAdapter = ChatsAdapter(chats)
        chatsAdapter.notifyDataSetChanged()

        binding.chatsRecyclerview.apply {
            adapter = chatsAdapter
            smoothScrollToPosition(chats.size - 1)
        }
    }
}