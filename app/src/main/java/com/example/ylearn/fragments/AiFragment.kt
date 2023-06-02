package com.example.ylearn.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ylearn.adapter.ChatsAdapter
import com.example.ylearn.databinding.FragmentAiBinding
import com.example.ylearn.model.chatModel.ChatModel
import com.example.ylearn.model.chatModel.Repository


class AiFragment : Fragment() {

    private  var _binding: FragmentAiBinding?= null
    private val binding  get() = _binding!!

    private var chats = arrayListOf<ChatModel>()
    private lateinit var chatsAdapter: ChatsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_ai, container, false)
        _binding = FragmentAiBinding.inflate(inflater, container, false)


        initRecyclerView()


        return binding.root


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