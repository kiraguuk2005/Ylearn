package com.example.ylearn.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.example.ylearn.R
import com.example.ylearn.model.videoModel.VideoModel
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions


class VideoAdapter(options: FirebaseRecyclerOptions<VideoModel?>) :
    FirebaseRecyclerAdapter<VideoModel?, VideoAdapter.MyViewHolder?>(options) {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var videoView: VideoView
        var title: TextView
        var desc: TextView
        var pbar: ProgressBar
        var fav : ImageView
        var isFav = false
        fun setdata(obj: VideoModel) {
            videoView.setVideoPath(obj.url)
            title.setText(obj.title)
            desc.setText(obj.desc)
            videoView.setOnPreparedListener { mediaPlayer ->
                pbar.visibility = View.GONE
                mediaPlayer.start()
            }
            videoView.setOnCompletionListener { mediaPlayer -> mediaPlayer.start() }
            fav.setOnClickListener {
                if (!isFav){
                    fav.setImageResource(R.drawable.ic_baseline_thumb_up_24)
                    isFav = true
                }
                else{
                    fav.setImageResource(R.drawable.thumbsup)
                    isFav = false
                }

            }
        }

        init {
            videoView = itemView.findViewById<View>(R.id.videoView) as VideoView
            title = itemView.findViewById<View>(R.id.textVideoTitle) as TextView
            desc = itemView.findViewById<View>(R.id.textVideoDescription) as TextView
            pbar = itemView.findViewById<View>(R.id.videoProgressBar) as ProgressBar
            fav = itemView.findViewById(R.id.favorites) as ImageView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.layout_videos, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int, model: VideoModel) {
        holder.setdata(model)
    }
}