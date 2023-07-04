package com.example.ylearn.bookfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ylearn.R
import com.example.ylearn.adapter.BooksAdapter
import com.example.ylearn.adapter.QuestionsAdapter
import com.example.ylearn.databinding.FragmentBooksBinding
import com.example.ylearn.model.booksModel.BooksData


class BooksFragment : Fragment() {
    private  var _binding: FragmentBooksBinding?= null
    private val binding  get() = _binding!!

    private lateinit var adapter: BooksAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var booksArrayList: ArrayList<BooksData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentBooksBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.gridBooksRecyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = BooksAdapter( booksArrayList, this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

    }

    private fun dataInitialize() {
        booksArrayList = arrayListOf(
            BooksData(R.drawable.b8,"Harry Potter", "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts"),
            BooksData(R.drawable.b8,"Harry Potter", "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts"),
            BooksData(R.drawable.b8,"Harry Potter", "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts"),
            BooksData(R.drawable.b8,"Harry Potter", "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts"),
            BooksData(R.drawable.b8,"Harry Potter", "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts"),
            BooksData(R.drawable.b8,"Harry Potter", "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts"),
            BooksData(R.drawable.b8,"Harry Potter", "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts"),
            BooksData(R.drawable.b8,"Harry Potter", "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts"),
            BooksData(R.drawable.b8,"Harry Potter", "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts"),
            BooksData(R.drawable.b8,"Harry Potter", "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts"),
            BooksData(R.drawable.b8,"Harry Potter", "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts"),
            BooksData(R.drawable.b8,"Harry Potter", "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts"),
            BooksData(R.drawable.b8,"Harry Potter", "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts"),
            BooksData(R.drawable.b8,"Harry Potter", "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts"),
            BooksData(R.drawable.b8,"Harry Potter", "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts"),
            BooksData(R.drawable.b8,"Harry Potter", "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts"),
            BooksData(R.drawable.b8,"Harry Potter", "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts"),
            BooksData(R.drawable.b8,"Harry Potter", "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts"),
            BooksData(R.drawable.b8,"Harry Potter", "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts"),
            BooksData(R.drawable.b8,"Harry Potter", "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts"),
            BooksData(R.drawable.b8,"Harry Potter", "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts"),
            BooksData(R.drawable.b8,"Harry Potter", "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts"),
            BooksData(R.drawable.b8,"Harry Potter", "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts"),
        )

    }


}