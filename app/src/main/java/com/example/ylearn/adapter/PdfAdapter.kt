package com.example.ylearn.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ylearn.databinding.PdfItemBinding
import com.example.ylearn.model.booksModel.BooksData
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
                tvPdfTitle.text = pdf.title
                tvPdfDesc.text = pdf.description
                tvPdfSupport.text = pdf.supportLink
            }
            pdfItemBinding.root.setOnClickListener {
                action.onPdfClick(pdf, adapterPosition)
            }
        }

    }

    private val pdfsList = ArrayList<PDFData>()
    private val fullList = ArrayList<PDFData>()

    fun filterList(search: String) {
        pdfsList.clear()

        for (item in fullList) {
            if (item.title?.lowercase()
                    ?.contains(search.lowercase()) == true || item.description?.lowercase()
                    ?.contains(search.lowercase()) == true
            ) {
                pdfsList.add(item)
            }
        }
        notifyDataSetChanged()

    }

    fun updateList(list: List<PDFData>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()

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