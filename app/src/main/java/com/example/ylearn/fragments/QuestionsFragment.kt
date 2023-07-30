package com.example.ylearn.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ylearn.FloatingForm
import com.example.ylearn.QuestionDetail
import com.example.ylearn.R
import com.example.ylearn.adapter.QuestionsAdapter
import com.example.ylearn.databinding.FragmentQuestionsBinding
import com.example.ylearn.model.QuestionsData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class QuestionsFragment : Fragment(), QuestionsAdapter.onQuestionClickLisener {

    private var _binding: FragmentQuestionsBinding? = null
    private val binding get() = _binding!!


    private lateinit var adapter: QuestionsAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var questionArrayList: ArrayList<QuestionsData>

//    var database = FirebaseDatabase.getInstance()
//    val questionsReference = database.getReference("ppatientrequest")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        _binding = FragmentQuestionsBinding.inflate(inflater, container, false)


        return binding.root


    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.timeLineRecyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = QuestionsAdapter(questionArrayList, this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

//        loadQuestions("SDF")

        binding.FAB.setOnClickListener {
            val intent = Intent(requireActivity(), FloatingForm::class.java)
            startActivity(intent)
        }

    }

    private fun dataInitialize() {
        questionArrayList = arrayListOf(
            QuestionsData(
                R.drawable.user,
                "Jeff",
                "Food",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's",
                "1 hour",
                "11k Views",
                "Answers : 5 M"
            ),
            QuestionsData(
                R.drawable.user,
                "Jeff",
                "Fifa",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's",
                "2 hour",
                "11k Views",
                "Answers : 5 M"
            ),
            QuestionsData(
                R.drawable.user,
                "Jeff",
                "Programming",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's",
                "3 hour",
                "11k Views",
                "Answers : 5 M"
            ),
            QuestionsData(
                R.drawable.user,
                "Jeff",
                "games",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's",
                "1 hour",
                "11k Views",
                "Answers : 5 M"
            ),
            QuestionsData(
                R.drawable.user,
                "Jeff",
                "Programming",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's",
                "5 hour",
                "11k Views",
                "Answers : 5 M"
            ),
            QuestionsData(
                R.drawable.user,
                "Jeff",
                "Programming",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's",
                "1 hour",
                "11k Views",
                "Answers : 5 M"
            ),
            QuestionsData(
                R.drawable.user,
                "Jeff",
                "Programming",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's",
                "7 hour",
                "11k Views",
                "Answers : 5 M"
            ),
            QuestionsData(
                R.drawable.user,
                "Jeff",
                "Programming",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's",
                "1 hour",
                "11k Views",
                "Answers : 5 M"
            ),
            QuestionsData(
                R.drawable.user,
                "Jeff",
                "Programming",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's",
                "1 hour",
                "11k Views",
                "Answers : 5 M"
            ),
            QuestionsData(
                R.drawable.user,
                "Jeff",
                "Programming",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's",
                "1 hour",
                "11k Views",
                "Answers : 5 M"
            ),
            QuestionsData(
                R.drawable.user,
                "Jeff",
                "Programming",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's",
                "1 hour",
                "11k Views",
                "Answers : 5 M"
            ),
            QuestionsData(
                R.drawable.user,
                "Jeff",
                "Programming",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's",
                "1 hour",
                "11k Views",
                "Answers : 5 M"
            ),
            QuestionsData(
                R.drawable.user,
                "Jeff",
                "Programming",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's",
                "1 hour",
                "11k Views",
                "Answers : 5 M"
            ),
            QuestionsData(
                R.drawable.user,
                "Jeff",
                "Programming",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's",
                "1 hour",
                "11k Views",
                "Answers : 5 M"
            ),
            QuestionsData(
                R.drawable.user,
                "Jeff",
                "Programming",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's",
                "1 hour",
                "11k Views",
                "Answers : 5 M"
            ),
            QuestionsData(
                R.drawable.user,
                "Jeff",
                "Programming",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's",
                "1 hour",
                "11k Views",
                "Answers : 5 M"
            ),
        )

    }

    override fun onClick(question: QuestionsData, position: Int) {
        val intent = Intent(requireActivity(), QuestionDetail::class.java)
        intent.putExtra("image", question.image.toString())
        intent.putExtra("username", question.userName)
        intent.putExtra("topic", question.topic)
        intent.putExtra("time", question.time)
        intent.putExtra("content", question.message)
        startActivity(intent)
    }

//    fun loadQuestions(prodkey: String?) {
//        questionsReference.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                var questionArrayList = ArrayList<QuestionsData>()
//                for (childSnapshot in dataSnapshot.children) {
//                    val question = childSnapshot.getValue(QuestionsData::class.java)
//                    question?.let { questionArrayList.add(it) }
//                }
//                questionArrayList = questionArrayList.reversed() as ArrayList<QuestionsData>
//                adapter = QuestionsAdapter(questionArrayList, this@QuestionsFragment)
//                recyclerView.adapter = adapter
//                adapter.notifyDataSetChanged()
//            }
//
//            override fun onCancelled(databaseError: DatabaseError) {
//                // Handle the error
//            }
//        })
//    }


}