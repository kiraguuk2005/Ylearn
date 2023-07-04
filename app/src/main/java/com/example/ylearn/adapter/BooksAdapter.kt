package com.example.ylearn.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ylearn.bookfragment.BooksFragment
import com.example.ylearn.databinding.BookCardItemBinding
import com.example.ylearn.model.booksModel.BooksData

class BooksAdapter(private val list: ArrayList<BooksData>, booksFragment: BooksFragment): RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {

    inner class BooksViewHolder( val bookCardItemBinding: BookCardItemBinding): RecyclerView.ViewHolder(bookCardItemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        return BooksViewHolder(BookCardItemBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder. bookCardItemBinding.ivPost.setImageResource(list[position].image)
        holder.bookCardItemBinding.tvTitle.text = list[position].title
        holder.bookCardItemBinding.tvContent.text = list[position].content
    }

    override fun getItemCount(): Int {
        return list.size
    }

}