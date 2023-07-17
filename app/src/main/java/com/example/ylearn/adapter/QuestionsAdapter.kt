package com.example.ylearn.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ylearn.databinding.TimeLineItemBinding
import com.example.ylearn.model.QuestionsData

class QuestionsAdapter(
    private val list: ArrayList<QuestionsData>,
    val clickListener: onQuestionClickLisener
) :
    RecyclerView.Adapter<QuestionsAdapter.QuestionsView>() {

    inner class QuestionsView(val timeLineItemBinding: TimeLineItemBinding) :
        RecyclerView.ViewHolder(timeLineItemBinding.root) {
        fun setData(question: QuestionsData, action: onQuestionClickLisener) {
            timeLineItemBinding.apply {
                imageView.setImageResource(question.image)
                tvUserName.text = question.userName
                tvContent.text = question.message
                tvTime.text = question.time
                tvTopic.text = question.topic
                tvViews.text = question.views
                tvAnswers.text = question.answers
            }
            timeLineItemBinding.root.setOnClickListener {
                action.onClick(question, adapterPosition)
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionsView {
        return QuestionsView(
            TimeLineItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: QuestionsView, position: Int) {
        val question = list[position]
        holder.setData(question, clickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface onQuestionClickLisener {

        fun onClick(question: QuestionsData, position: Int)

    }


}