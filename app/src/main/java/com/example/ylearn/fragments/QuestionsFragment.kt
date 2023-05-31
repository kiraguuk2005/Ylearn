package com.example.ylearn.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ylearn.R
import com.example.ylearn.adapter.QuestionsAdapter
import com.example.ylearn.model.QuestionsData

class QuestionsFragment : Fragment() {

    private lateinit var adapter: QuestionsAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var questionArrayList: ArrayList<QuestionsData>

    lateinit var image: Array<Int>
    lateinit var username: Array<String>
    lateinit var topic: Array<String>
    lateinit var message: Array<String>
    lateinit var time: Array<String>
    lateinit var views: Array<String>
    lateinit var answers: Array<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_questions, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.timeLineRecyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = QuestionsAdapter(questionArrayList)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun dataInitialize() {
        questionArrayList = arrayListOf(
            QuestionsData(R.drawable.user, "Jeff","Food","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's", "1 hour","11k Views", "Answers : 5 M"),
            QuestionsData(R.drawable.user, "Jeff","Fifa","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's", "2 hour","11k Views", "Answers : 5 M"),
            QuestionsData(R.drawable.user, "Jeff","Programming","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's", "3 hour","11k Views", "Answers : 5 M"),
            QuestionsData(R.drawable.user, "Jeff","games","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's", "1 hour","11k Views", "Answers : 5 M"),
            QuestionsData(R.drawable.user, "Jeff","Programming","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's", "5 hour","11k Views", "Answers : 5 M"),
            QuestionsData(R.drawable.user, "Jeff","Programming","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's", "1 hour","11k Views", "Answers : 5 M"),
            QuestionsData(R.drawable.user, "Jeff","Programming","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's", "7 hour","11k Views", "Answers : 5 M"),
            QuestionsData(R.drawable.user, "Jeff","Programming","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's", "1 hour","11k Views", "Answers : 5 M"),
            QuestionsData(R.drawable.user, "Jeff","Programming","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's", "1 hour","11k Views", "Answers : 5 M"),
            QuestionsData(R.drawable.user, "Jeff","Programming","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's", "1 hour","11k Views", "Answers : 5 M"),
            QuestionsData(R.drawable.user, "Jeff","Programming","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's", "1 hour","11k Views", "Answers : 5 M"),
            QuestionsData(R.drawable.user, "Jeff","Programming","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's", "1 hour","11k Views", "Answers : 5 M"),
            QuestionsData(R.drawable.user, "Jeff","Programming","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's", "1 hour","11k Views", "Answers : 5 M"),
            QuestionsData(R.drawable.user, "Jeff","Programming","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's", "1 hour","11k Views", "Answers : 5 M"),
            QuestionsData(R.drawable.user, "Jeff","Programming","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's", "1 hour","11k Views", "Answers : 5 M"),
            QuestionsData(R.drawable.user, "Jeff","Programming","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's", "1 hour","11k Views", "Answers : 5 M"),
        )


    }


}