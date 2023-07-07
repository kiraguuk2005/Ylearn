package com.example.ylearn.bookfragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ylearn.ClickRecyclerBook
import com.example.ylearn.R
import com.example.ylearn.ReadBook
import com.example.ylearn.adapter.BooksAdapter
import com.example.ylearn.databinding.FragmentBooksBinding
import com.example.ylearn.model.booksModel.BooksData


class BooksFragment : Fragment(), BooksAdapter.OnBookClickListener {
    private var _binding: FragmentBooksBinding? = null
    private val binding get() = _binding!!

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
        adapter = BooksAdapter(booksArrayList, this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

        binding.btnRead.setOnClickListener {
            val intent = Intent(requireActivity(), ReadBook::class.java)
            startActivity(intent)
        }

    }

    private fun dataInitialize() {
        booksArrayList = arrayListOf(
            BooksData(
                R.drawable.b8,
                "Harry Potter",
                "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts",
                "Ksh 1000"
            ),
            BooksData(
                R.drawable.book1,
                "Frankenstein",
                "Frankenstein; or, The Modern Prometheus is an 1818 novel written by English author Mary Shelley. Frankenstein tells the story of Victor Frankenstein, a young scientist who creates a sapient creature in an unorthodox scientific experiment. Shelley started writing the story when she was 18, and the first edition was published anonymously in London on 1 January 1818, when she was 20. Her name first appeared in the second edition, which was published in Paris in 1821.",
                "Ksh 1200"
            ),
            BooksData(
                R.drawable.book2,
                "Nineteen Eighty-Four",
                "Nineteen Eighty-Four is a dystopian social science fiction novel and cautionary tale by English writer George Orwell. It was published on 8 June 1949 by Secker & Warburg as Orwell's ninth and final book completed in his lifetime",
                "Ksh 500"
            ),
            BooksData(
                R.drawable.book1,
                "Frankenstein",
                "Frankenstein; or, The Modern Prometheus is an 1818 novel written by English author Mary Shelley. Frankenstein tells the story of Victor Frankenstein, a young scientist who creates a sapient creature in an unorthodox scientific experiment",
                "Ksh 1200"
            ),
            BooksData(
                R.drawable.b8,
                "Harry Potter",
                "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts",
                "Ksh 1000"
            ),
            BooksData(
                R.drawable.book2,
                "Nineteen Eighty-Four",
                "Nineteen Eighty-Four is a dystopian social science fiction novel and cautionary tale by English writer George Orwell. It was published on 8 June 1949 by Secker & Warburg as Orwell's ninth and final book completed in his lifetime",
                "Ksh 500"
            ),
            BooksData(
                R.drawable.b8,
                "Harry Potter",
                "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts",
                "Ksh 1000"
            ),
            BooksData(
                R.drawable.book1,
                "Frankenstein",
                "Frankenstein; or, The Modern Prometheus is an 1818 novel written by English author Mary Shelley. Frankenstein tells the story of Victor Frankenstein, a young scientist who creates a sapient creature in an unorthodox scientific experiment",
                "Ksh 1200"
            ),
            BooksData(
                R.drawable.book2,
                "Nineteen Eighty-Four",
                "Nineteen Eighty-Four is a dystopian social science fiction novel and cautionary tale by English writer George Orwell. It was published on 8 June 1949 by Secker & Warburg as Orwell's ninth and final book completed in his lifetime",
                "Ksh 500"
            ),
            BooksData(
                R.drawable.b8,
                "Harry Potter",
                "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts",
                "Ksh 1000"
            ),
            BooksData(
                R.drawable.book2,
                "Nineteen Eighty-Four",
                "Nineteen Eighty-Four is a dystopian social science fiction novel and cautionary tale by English writer George Orwell. It was published on 8 June 1949 by Secker & Warburg as Orwell's ninth and final book completed in his lifetime",
                "Ksh 500"
            ),
            BooksData(
                R.drawable.book1,
                "Frankenstein",
                "Frankenstein; or, The Modern Prometheus is an 1818 novel written by English author Mary Shelley. Frankenstein tells the story of Victor Frankenstein, a young scientist who creates a sapient creature in an unorthodox scientific experiment",
                "Ksh 1200"
            ),
            BooksData(
                R.drawable.b8,
                "Harry Potter",
                "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts",
                "Ksh 1000"
            ),
            BooksData(
                R.drawable.book1,
                "Frankenstein",
                "Frankenstein; or, The Modern Prometheus is an 1818 novel written by English author Mary Shelley. Frankenstein tells the story of Victor Frankenstein, a young scientist who creates a sapient creature in an unorthodox scientific experiment",
                "Ksh 1200"
            ),
            BooksData(
                R.drawable.b8,
                "Harry Potter",
                "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts",
                "Ksh 1000"
            ),
            BooksData(
                R.drawable.book1,
                "Frankenstein",
                "Frankenstein; or, The Modern Prometheus is an 1818 novel written by English author Mary Shelley. Frankenstein tells the story of Victor Frankenstein, a young scientist who creates a sapient creature in an unorthodox scientific experiment",
                "Ksh 1200"
            ),
            BooksData(
                R.drawable.book2,
                "Nineteen Eighty-Four",
                "Nineteen Eighty-Four is a dystopian social science fiction novel and cautionary tale by English writer George Orwell. It was published on 8 June 1949 by Secker & Warburg as Orwell's ninth and final book completed in his lifetime",
                "Ksh 500"
            ),
            BooksData(
                R.drawable.b8,
                "Harry Potter",
                "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts",
                "Ksh 1000"
            ),
            BooksData(
                R.drawable.book1,
                "Frankenstein",
                "Frankenstein; or, The Modern Prometheus is an 1818 novel written by English author Mary Shelley. Frankenstein tells the story of Victor Frankenstein, a young scientist who creates a sapient creature in an unorthodox scientific experiment",
                "Ksh 1200"
            ),
            BooksData(
                R.drawable.b8,
                "Harry Potter",
                "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts",
                "Ksh 1000"
            ),
            BooksData(
                R.drawable.book1,
                "Frankenstein",
                "Frankenstein; or, The Modern Prometheus is an 1818 novel written by English author Mary Shelley. Frankenstein tells the story of Victor Frankenstein, a young scientist who creates a sapient creature in an unorthodox scientific experiment",
                "Ksh 1200"
            ),
            BooksData(
                R.drawable.b8,
                "Harry Potter",
                "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts",
                "Ksh 1000"
            ),
            BooksData(
                R.drawable.book2,
                "Nineteen Eighty-Four",
                "Nineteen Eighty-Four is a dystopian social science fiction novel and cautionary tale by English writer George Orwell. It was published on 8 June 1949 by Secker & Warburg as Orwell's ninth and final book completed in his lifetime",
                "Ksh 500"
            ),
        )

    }

    override fun onBookClick(book: BooksData, position: Int) {
        val intent = Intent(requireActivity(), ClickRecyclerBook::class.java)
        intent.putExtra("image", book.image.toString())
        intent.putExtra("title", book.title)
        intent.putExtra("content", book.content)
        intent.putExtra("price", book.price)
        startActivity(intent)
    }


}