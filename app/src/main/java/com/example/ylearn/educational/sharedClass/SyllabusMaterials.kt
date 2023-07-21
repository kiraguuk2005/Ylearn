package com.example.ylearn.educational.sharedClass

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ylearn.R
import com.example.ylearn.adapter.PdfAdapter
import com.example.ylearn.databinding.ActivitySylabusMaterialsBinding
import com.example.ylearn.educational.UploadMaterial
import com.example.ylearn.model.pdfModel.PDFData
import com.example.ylearn.pdfViewModel.PdfViewModel
import com.google.firebase.database.FirebaseDatabase

class SyllabusMaterials : AppCompatActivity(), PdfAdapter.OnPdfClickListener {
    private lateinit var binding: ActivitySylabusMaterialsBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PdfAdapter
    private lateinit var pdfList: ArrayList<PDFData>
    private lateinit var viewModel: PdfViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySylabusMaterialsBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        FirebaseDatabase.getInstance().setPersistenceEnabled(true)

        binding.FAB.setOnClickListener {
            startActivity(Intent(this, UploadMaterial::class.java))
        }

        dataInitialize()
        val layoutManager = LinearLayoutManager(this)
        recyclerView = binding.timeLineRecyclerView
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = PdfAdapter(pdfList, this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()


        viewModel = ViewModelProvider(this).get(PdfViewModel::class.java)
        viewModel.allPdfs.observe(this, Observer {
            adapter.updateList(it)
        })

    }

    private fun dataInitialize() {
        pdfList = arrayListOf(
            PDFData(
                R.drawable.b8,
                "River and The Source",
                "What exactly in this code doesn't work the way you expect? Tell us what is wrong with shared code. Do you have any errors",
                "https://stackoverflow.com/questions/71093923/put-pdf-files-which-i-download-from-firebase-cloud-storage-to-recyclerview-using",
                ""
            ),
            PDFData(
                R.drawable.book1,
                "Elon Musk",
                "What exactly in this code doesn't work the way you expect? Tell us what is wrong with shared code. Do you have any errors",
                "https://stackoverflow.com/questions/71093923/put-pdf-files-which-i-download-from-firebase-cloud-storage-to-recyclerview-using",
                ""
            ),
            PDFData(
                R.drawable.b8,
                "Mark Zuckergag",
                "What exactly in this code doesn't work the way you expect? Tell us what is wrong with shared code. Do you have any errors",
                "https://stackoverflow.com/questions/71093923/put-pdf-files-which-i-download-from-firebase-cloud-storage-to-recyclerview-using",
                ""
            ),
            PDFData(
                R.drawable.book2,
                "Boys to Men",
                "What exactly in this code doesn't work the way you expect? Tell us what is wrong with shared code. Do you have any errors",
                "https://stackoverflow.com/questions/71093923/put-pdf-files-which-i-download-from-firebase-cloud-storage-to-recyclerview-using",
                ""
            ),
            PDFData(
                R.drawable.b8,
                "Power of the mind",
                "What exactly in this code doesn't work the way you expect? Tell us what is wrong with shared code. Do you have any errors",
                "https://stackoverflow.com/questions/71093923/put-pdf-files-which-i-download-from-firebase-cloud-storage-to-recyclerview-using",
                ""
            ),

            )

    }

    override fun onPdfClick(pdf: PDFData, position: Int) {
        val intent = Intent(this, OpenMaterials::class.java)
        intent.putExtra("image", pdf.image.toString())
        intent.putExtra("title", pdf.title)
        intent.putExtra("description", pdf.description)
        intent.putExtra("support", pdf.supportLink)
        intent.putExtra("pdfUrl", pdf.url)
        startActivity(intent)
    }
}