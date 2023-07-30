package com.example.ylearn.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ylearn.databinding.BookCardItemBinding
import com.example.ylearn.model.booksModel.BooksData

class BooksAdapter(private val list: ArrayList<BooksData>, val clickListener: OnBookClickListener) :
    RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {


    inner class BooksViewHolder(val bookCardItemBinding: BookCardItemBinding) :
        RecyclerView.ViewHolder(bookCardItemBinding.root) {

        fun setData(book: BooksData, action: OnBookClickListener) {
            bookCardItemBinding.apply {
                tvTitle.text = book.bookTitle
                tvContent.text = book.bookDescription
                tvPrice.text = book.bookPrice

            }
            bookCardItemBinding.root.setOnClickListener {
                action.onBookClick(book, adapterPosition)
            }
        }
    }

    private val booksList = ArrayList<BooksData>()
    private val fullList = ArrayList<BooksData>()

    fun filterList(search: String) {
        booksList.clear()

        for (item in fullList) {
            if (item.bookTitle?.lowercase()
                    ?.contains(search.lowercase()) == true || item.bookDescription?.lowercase()
                    ?.contains(search.lowercase()) == true
            ) {
                booksList.add(item)
            }
        }
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        return BooksViewHolder(
            BookCardItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        val book = list[position]
        holder.setData(book, clickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnBookClickListener {
        fun onBookClick(book: BooksData, position: Int)
    }
}