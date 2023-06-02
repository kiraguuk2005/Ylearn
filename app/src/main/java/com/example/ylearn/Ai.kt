package com.example.ylearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ylearn.adapter.ChatsAdapter
import com.example.ylearn.databinding.ActivityAiBinding
import com.example.ylearn.model.chatModel.ChatModel
import com.example.ylearn.model.chatModel.Repository

class Ai : AppCompatActivity() {

    private lateinit var binding: ActivityAiBinding
    private var chats = arrayListOf<ChatModel>()
    private lateinit var chatsAdapter: ChatsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAiBinding.inflate(layoutInflater)
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