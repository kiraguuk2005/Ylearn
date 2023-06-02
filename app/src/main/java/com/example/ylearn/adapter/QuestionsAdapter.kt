package com.example.ylearn.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ylearn.databinding.TimeLineItemBinding
import com.example.ylearn.model.QuestionsData

class QuestionsAdapter(private val list: ArrayList<QuestionsData>, private val clickListener: CardListener): RecyclerView.Adapter<QuestionsAdapter.QuestionsView>() {

    inner class QuestionsView(val timeLineItemBinding: TimeLineItemBinding): RecyclerView.ViewHolder(timeLineItemBinding.root), View.OnClickListener {
        override fun onClick(view: View?) {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                clickListener.onClickCard(view?.id)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionsView {
       return QuestionsView(TimeLineItemBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: QuestionsView, position: Int) {
        holder.timeLineItemBinding.imageView.setImageResource(list[position].image)
        holder.timeLineItemBinding.tvUserName.text = list[position].userName
        holder.timeLineItemBinding.tvContent.text = list[position].message
        holder.timeLineItemBinding.tvTime.text = list[position].time
        holder.timeLineItemBinding.tvTopic.text = list[position].topic
        holder.timeLineItemBinding.tvViews.text = list[position].views
        holder.timeLineItemBinding.tvAnswers.text = list[position].answers
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface CardListener{
        fun onClickCard(id:Int?){

        }
    }


}