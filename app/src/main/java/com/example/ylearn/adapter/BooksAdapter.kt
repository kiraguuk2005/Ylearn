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
                ivPost.setImageResource(book.image)
                tvTitle.text = book.title
                tvContent.text = book.content
                tvPrice.text = book.price
            }
            bookCardItemBinding.root.setOnClickListener {
                action.onBookClick(book, adapterPosition)
            }
        }
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