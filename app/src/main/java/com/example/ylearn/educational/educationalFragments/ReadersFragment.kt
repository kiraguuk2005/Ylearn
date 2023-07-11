package com.example.ylearn.educational.educationalFragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ylearn.R
import com.example.ylearn.adapter.PdfAdapter
import com.example.ylearn.databinding.FragmentReadersBinding
import com.example.ylearn.educational.OpenMaterials
import com.example.ylearn.educational.UploadMaterial
import com.example.ylearn.model.pdfModel.PDFData


class ReadersFragment : Fragment(), PdfAdapter.OnPdfClickListener {
    private var _binding: FragmentReadersBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PdfAdapter
    private lateinit var pdfList: ArrayList<PDFData>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReadersBinding.inflate(inflater, container, false)


        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.timeLineRecyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = PdfAdapter(pdfList, this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

        binding.FAB.setOnClickListener {
            val intent = Intent(requireActivity(), UploadMaterial::class.java)
            startActivity(intent)
        }

    }

    private fun dataInitialize() {
        pdfList = arrayListOf(
            PDFData(R.drawable.b8, "River and The Source"),
            PDFData(R.drawable.book1, "Elon Musk"),
            PDFData(R.drawable.b8, "Mark Zuckergag"),
            PDFData(R.drawable.book2, "Boys to Men"),
            PDFData(R.drawable.b8, "Power of the mind"),
            PDFData(R.drawable.book1, "River and The Source"),
            PDFData(R.drawable.b8, "River and The Source"),
            PDFData(R.drawable.book2, "River and The Source"),
            PDFData(R.drawable.b8, "River and The Source"),
            PDFData(R.drawable.book1, "River and The Source"),
        )

    }

    override fun onPdfClick(pdf: PDFData, position: Int) {
        val intent = Intent(requireActivity(), OpenMaterials::class.java)
        intent.putExtra("image", pdf.image.toString())
        intent.putExtra("title", pdf.title)
        startActivity(intent)
    }

}