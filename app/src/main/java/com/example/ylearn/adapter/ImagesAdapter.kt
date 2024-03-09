package com.example.ylearn.adapter

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.ylearn.R
import com.example.ylearn.model.advert.AdData

class ImagesAdapter(private val list: ArrayList<AdData>) :
    RecyclerView.Adapter<ImagesAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val adtitle: EditText = view.findViewById(R.id.title)
        val adcontact: EditText = view.findViewById(R.id.contactInfo)
        val addescription: EditText = view.findViewById(R.id.desc)
        val adimage: ImageView = view.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
        holder.adtitle.setText(data.title.toString())
        holder.adcontact.setText(data.contact.toString())
        holder.addescription.setText(data.desc.toString())
        val bytes = android.util.Base64.decode(data.imageUrl, android.util.Base64.DEFAULT)
        val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
        holder.adimage.setImageBitmap(bitmap)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}


//class ImagesAdapter(private val list: ArrayList<AdData>, val clickListener: OnAdvertClickListener) :
//    RecyclerView.Adapter<ImagesAdapter.ImagesViewHolder>() {
//
//    inner class ImagesViewHolder(val eachItemBinding: EachItemBinding) :
//        RecyclerView.ViewHolder(eachItemBinding.root) {
//        fun setData(ad: AdData, action: OnAdvertClickListener) {
//            eachItemBinding.apply {
//                title.text = ad.title
////                imageView.setImageResource(ad.imageUrl)
////                ad.imageUrl?.let { imageView.setImageResource(it) }
//            }
//            eachItemBinding.root.setOnClickListener {
//                action.onAdClick(ad, adapterPosition)
//            }
//        }
//    }
//
//
//    interface OnAdvertClickListener {
//        fun onAdClick(ad: AdData, position: Int)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
//        return ImagesViewHolder(
//            EachItemBinding.inflate(
//                LayoutInflater.from(parent.context),
//                parent,
//                false
//            )
//        )
//    }
//
//    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
//        val ad = list[position]
//        holder.setData(ad, clickListener)
//    }
//
//    override fun getItemCount(): Int {
//        return list.size
//    }
//}