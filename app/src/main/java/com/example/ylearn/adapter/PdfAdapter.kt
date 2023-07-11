package com.example.ylearn.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ylearn.databinding.PdfItemBinding
import com.example.ylearn.educational.educationalFragments.ReadersFragment
import com.example.ylearn.model.pdfModel.PDFData

class PdfAdapter(
    private val list: ArrayList<PDFData>,
    val clickListener: OnPdfClickListener
) :
    RecyclerView.Adapter<PdfAdapter.PdfViewHolder>() {

    inner class PdfViewHolder(val pdfItemBinding: PdfItemBinding) :
        RecyclerView.ViewHolder(pdfItemBinding.root) {
        fun setData(pdf: PDFData, action: PdfAdapter.OnPdfClickListener) {
            pdfItemBinding.apply {
                ivBookIcon.setImageResource(pdf.image)
                tvPdfTitle.text = pdf.title

            }
            pdfItemBinding.root.setOnClickListener {
                action.onPdfClick(pdf, adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PdfViewHolder {
        return PdfViewHolder(
            PdfItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PdfViewHolder, position: Int) {
        val pdf = list[position]
        holder.setData(pdf, clickListener)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnPdfClickListener {
        fun onPdfClick(pdf: PDFData, position: Int)
    }


}