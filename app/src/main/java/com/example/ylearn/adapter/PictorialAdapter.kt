package com.example.ylearn.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ylearn.databinding.ImagequizItemBinding
import com.example.ylearn.fragments.SearchFragment
import com.example.ylearn.model.PictorialquizData


class PictorialAdapter(
    private val list: MutableList<PictorialquizData>,
    val clickListener: onQuizClickListener
) :
    RecyclerView.Adapter<PictorialAdapter.quizViewHolder>() {

    inner class quizViewHolder(val imagequizItemBinding: ImagequizItemBinding) :
        RecyclerView.ViewHolder(imagequizItemBinding.root) {
        fun setData(quiz: PictorialquizData, action: onQuizClickListener) {
            imagequizItemBinding.apply {
                quizTitle.text = quiz.quizTitle
                quizDescription.text = quiz.quizDescription

            }
            imagequizItemBinding.root.setOnClickListener {
                action.onQuizClick(quiz, adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): quizViewHolder {
        return quizViewHolder(
            ImagequizItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: quizViewHolder, position: Int) {
        val quiz = list[position]
        holder.setData(quiz, clickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface onQuizClickListener {
        fun onQuizClick(quiz: PictorialquizData, position: Int)
    }
}