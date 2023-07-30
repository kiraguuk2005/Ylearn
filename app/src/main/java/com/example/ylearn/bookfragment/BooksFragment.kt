package com.example.ylearn.bookfragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ylearn.ClickRecyclerBook
import com.example.ylearn.R
import com.example.ylearn.ReadBook
import com.example.ylearn.adapter.BooksAdapter
import com.example.ylearn.databinding.FragmentBooksBinding
import com.example.ylearn.model.booksModel.BooksData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class BooksFragment : Fragment(), BooksAdapter.OnBookClickListener {
    private var _binding: FragmentBooksBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: BooksAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var booksArrayList: ArrayList<BooksData>

    //read pdfs,
    var database = FirebaseDatabase.getInstance()
    val booksReference = database.getReference("books")

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

        loadBooks("mybooks")

        binding.btnRead.setOnClickListener {
            val intent = Intent(requireActivity(), ReadBook::class.java)
            startActivity(intent)
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    adapter.filterList(newText)
                }
                return true
            }

        })


    }

    fun loadBooks(prodkey: String?) {
        booksReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var bookArrayList = ArrayList<BooksData>()
                for (childSnapshot in dataSnapshot.children) {
                    val books = childSnapshot.getValue(BooksData::class.java)
                    books?.let { bookArrayList.add(it) }
                }
                adapter = BooksAdapter(bookArrayList, this@BooksFragment)
                recyclerView.adapter = adapter
                adapter.notifyDataSetChanged()

            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle the error
            }
        })

    }

    private fun dataInitialize() {
        booksArrayList = arrayListOf(
            BooksData(
                "Harry Potter",
                "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts",
                "Ksh 1000",
                "",
                ""
            ),
            BooksData(
                "Nineteen Eighty-Four",
                "Nineteen Eighty-Four is a dystopian social science fiction novel and cautionary tale by English writer George Orwell. It was published on 8 June 1949 by Secker & Warburg as Orwell's ninth and final book completed in his lifetime",
                "Ksh 500",
                "",
                ""
            ),
            BooksData(
                "Frankenstein",
                "Frankenstein; or, The Modern Prometheus is an 1818 novel written by English author Mary Shelley. Frankenstein tells the story of Victor Frankenstein, a young scientist who creates a sapient creature in an unorthodox scientific experiment",
                "Ksh 1200",
                "",
                ""
            ),
            BooksData(
                "Harry Potter",
                "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts",
                "Ksh 1000",
                "",
                ""
            ),
            BooksData(
                "Frankenstein",
                "Frankenstein; or, The Modern Prometheus is an 1818 novel written by English author Mary Shelley. Frankenstein tells the story of Victor Frankenstein, a young scientist who creates a sapient creature in an unorthodox scientific experiment",
                "Ksh 1200",
                "",
                ""
            ),
            BooksData(
                "Harry Potter",
                "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts",
                "Ksh 1000",
                "",
                ""
            ),
            BooksData(
                "Frankenstein",
                "Frankenstein; or, The Modern Prometheus is an 1818 novel written by English author Mary Shelley. Frankenstein tells the story of Victor Frankenstein, a young scientist who creates a sapient creature in an unorthodox scientific experiment",
                "Ksh 1200",
                "",
                ""
            ),
            BooksData(
                "Nineteen Eighty-Four",
                "Nineteen Eighty-Four is a dystopian social science fiction novel and cautionary tale by English writer George Orwell. It was published on 8 June 1949 by Secker & Warburg as Orwell's ninth and final book completed in his lifetime",
                "Ksh 500",
                "",
                ""
            ),
            BooksData(
                "Harry Potter",
                "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts",
                "Ksh 1000",
                "",
                ""
            ),
            BooksData(
                "Frankenstein",
                "Frankenstein; or, The Modern Prometheus is an 1818 novel written by English author Mary Shelley. Frankenstein tells the story of Victor Frankenstein, a young scientist who creates a sapient creature in an unorthodox scientific experiment",
                "Ksh 1200",
                "",
                ""
            ),
            BooksData(

                "Harry Potter",
                "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts",
                "Ksh 1000",
                "",
                ""
            ),
            BooksData(

                "Frankenstein",
                "Frankenstein; or, The Modern Prometheus is an 1818 novel written by English author Mary Shelley. Frankenstein tells the story of Victor Frankenstein, a young scientist who creates a sapient creature in an unorthodox scientific experiment",
                "Ksh 1200",
                "",
                ""
            ),
            BooksData(

                "Harry Potter",
                "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts",
                "Ksh 1000",
                "",
                ""
            ),
            BooksData(
                "Nineteen Eighty-Four",
                "Nineteen Eighty-Four is a dystopian social science fiction novel and cautionary tale by English writer George Orwell. It was published on 8 June 1949 by Secker & Warburg as Orwell's ninth and final book completed in his lifetime",
                "Ksh 500",
                "",
                ""
            ),
        )

    }

    override fun onBookClick(book: BooksData, position: Int) {
        val intent = Intent(requireActivity(), ClickRecyclerBook::class.java)
        intent.putExtra("title", book.bookTitle)
        intent.putExtra("description", book.bookDescription)
        intent.putExtra("price", book.bookPrice)
        startActivity(intent)
    }


}