package com.example.ylearn.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ylearn.databinding.AnswerItemBinding
import com.example.ylearn.model.AnswersData

class AnswersAdapter(private val list: ArrayList<AnswersData>, val clickListener: OnAnswerClickListener) :
    RecyclerView.Adapter<AnswersAdapter.AnswersViewHolder>() {

    inner class AnswersViewHolder(val answerItemBinding: AnswerItemBinding) :
        RecyclerView.ViewHolder(answerItemBinding.root) {
        fun setData(answer: AnswersData, action: AnswersAdapter.OnAnswerClickListener) {
            answerItemBinding.apply {
                imageView.setImageResource(answer.image)
                tvUserName.text = answer.userName
                tvContent.text = answer.message
                tvTopic.text = answer.topic
                tvTime.text = answer.time

            }
            answerItemBinding.root.setOnClickListener {
                action.onAnswerClick(answer, adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswersViewHolder {
        return AnswersViewHolder(
            AnswerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AnswersViewHolder, position: Int) {
        val answer = list[position]
        holder.setData(answer, clickListener)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnAnswerClickListener {
        fun onAnswerClick(answer: AnswersData, position: Int)
    }
}