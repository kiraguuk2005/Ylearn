package com.example.ylearn

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ylearn.adapter.AnswersAdapter
import com.example.ylearn.databinding.ActivityQuestionDetailBinding
import com.example.ylearn.educational.sharedClass.OpenMaterials
import com.example.ylearn.model.AnswersData

class QuestionDetail : AppCompatActivity(), AnswersAdapter.OnAnswerClickListener {

    private lateinit var binding: ActivityQuestionDetailBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AnswersAdapter
    private lateinit var answerList: ArrayList<AnswersData>

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityQuestionDetailBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }

        binding.apply {
            intent

            imageView.setImageResource(intent.getStringExtra("image")!!.toInt())
            tvUserName.text = intent.getStringExtra("username")
            tvTopic.text = intent.getStringExtra("topic")
            tvTime.text = intent.getStringExtra("time")
            tvContent.text = intent.getStringExtra("content")
        }

        binding.tvPostAnswer.setOnClickListener {
            val content = binding.tvContent.text.toString()
            val intent = Intent(this, Answers::class.java)
            intent.putExtra("cont", content)
            startActivity(intent)
        }

        dataInitialize()
        val layoutManager = LinearLayoutManager(this)
        recyclerView = binding.timeLineRecyclerView
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = AnswersAdapter(answerList, this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

    }

    override fun onAnswerClick(answer: AnswersData, position: Int) {
        val intent = Intent(this, OpenAnswer::class.java)
        intent.putExtra("image", answer.image.toString())
        intent.putExtra("user", answer.userName)
        intent.putExtra("topic", answer.topic)
        intent.putExtra("message", answer.message)
        intent.putExtra("time", answer.time)
        startActivity(intent)
    }

    private fun dataInitialize() {
        answerList = arrayListOf(
            AnswersData(
                R.drawable.user,
                "John Doe",
                "Data Stuctures",
                "What exactly in this code doesn't work the way you expect? Tell us what is wrong with shared code. Do you have any errors",
                "2 hours"
            ),
            AnswersData(
                R.drawable.user,
                "John Doe",
                "Data Stuctures",
                "What exactly in this code doesn't work the way you expect? Tell us what is wrong with shared code. Do you have any errors",
                "2 hours"
            ),
            AnswersData(
                R.drawable.user,
                "John Doe",
                "Data Stuctures",
                "What exactly in this code doesn't work the way you expect? Tell us what is wrong with shared code. Do you have any errors",
                "2 hours"
            ),
            AnswersData(
                R.drawable.user,
                "John Doe",
                "Data Stuctures",
                "What exactly in this code doesn't work the way you expect? Tell us what is wrong with shared code. Do you have any errors",
                "2 hours"
            ),
            AnswersData(
                R.drawable.user,
                "John Doe",
                "Data Stuctures",
                "What exactly in this code doesn't work the way you expect? Tell us what is wrong with shared code. Do you have any errors",
                "2 hours"
            ),
            AnswersData(
                R.drawable.user,
                "John Doe",
                "Data Stuctures",
                "What exactly in this code doesn't work the way you expect? Tell us what is wrong with shared code. Do you have any errors",
                "2 hours"
            ),
            AnswersData(
                R.drawable.user,
                "John Doe",
                "Data Stuctures",
                "What exactly in this code doesn't work the way you expect? Tell us what is wrong with shared code. Do you have any errors",
                "2 hours"
            ),
            AnswersData(
                R.drawable.user,
                "John Doe",
                "Data Stuctures",
                "What exactly in this code doesn't work the way you expect? Tell us what is wrong with shared code. Do you have any errors",
                "2 hours"
            ),
            AnswersData(
                R.drawable.user,
                "John Doe",
                "Data Stuctures",
                "What exactly in this code doesn't work the way you expect? Tell us what is wrong with shared code. Do you have any errors",
                "2 hours"
            ),
            AnswersData(
                R.drawable.user,
                "John Doe",
                "Data Stuctures",
                "What exactly in this code doesn't work the way you expect? Tell us what is wrong with shared code. Do you have any errors",
                "2 hours"
            ),
            AnswersData(
                R.drawable.user,
                "John Doe",
                "Data Stuctures",
                "What exactly in this code doesn't work the way you expect? Tell us what is wrong with shared code. Do you have any errors",
                "2 hours"
            ),
            AnswersData(
                R.drawable.user,
                "John Doe",
                "Data Stuctures",
                "What exactly in this code doesn't work the way you expect? Tell us what is wrong with shared code. Do you have any errors",
                "2 hours"
            ),
            AnswersData(
                R.drawable.user,
                "John Doe",
                "Data Stuctures",
                "What exactly in this code doesn't work the way you expect? Tell us what is wrong with shared code. Do you have any errors",
                "2 hours"
            ),
        )


    }

}