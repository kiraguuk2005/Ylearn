package com.example.ylearn.educational.sharedClass

import android.content.Intent
import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ylearn.adapter.PdfAdapter
import com.example.ylearn.databinding.ActivitySylabusMaterialsBinding
import com.example.ylearn.educational.UploadMaterial
import com.example.ylearn.model.pdfModel.PDFData
import com.example.ylearn.pdfViewModel.PdfViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class SyllabusMaterials : AppCompatActivity(), PdfAdapter.OnPdfClickListener {
    private lateinit var binding: ActivitySylabusMaterialsBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PdfAdapter
    private lateinit var pdfList: ArrayList<PDFData>
    private lateinit var viewModel: PdfViewModel

    var database = FirebaseDatabase.getInstance()
    val pdfsReference = database.getReference("pdfs")


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySylabusMaterialsBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var receivedIntent = intent
        var level = receivedIntent.getStringExtra("level")
        var subject = receivedIntent.getStringExtra("subject")
        var grade = receivedIntent.getStringExtra("grade")



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
        loadPdfs("Mymaterials", level, subject, grade)
        adapter.notifyDataSetChanged()


        viewModel = ViewModelProvider(this).get(PdfViewModel::class.java)
        viewModel.allPdfs.observe(this, Observer {
            adapter.updateList(it)
        })

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    adapter.filterList(newText)
                }
                return true
            }

        })

    }

    private fun dataInitialize() {
        pdfList = arrayListOf(
            PDFData(
                "River and The Source",
                "What exactly in this code doesn't work the way you expect? Tell us what is wrong with shared code. Do you have any errors",
                "https://stackoverflow.com/questions/71093923/put-pdf-files-which-i-download-from-firebase-cloud-storage-to-recyclerview-using",
                ""
            ),
            PDFData(
                "Elon Musk",
                "What exactly in this code doesn't work the way you expect? Tell us what is wrong with shared code. Do you have any errors",
                "https://stackoverflow.com/questions/71093923/put-pdf-files-which-i-download-from-firebase-cloud-storage-to-recyclerview-using",
                ""
            ),
            PDFData(
                "Mark Zuckergag",
                "What exactly in this code doesn't work the way you expect? Tell us what is wrong with shared code. Do you have any errors",
                "https://stackoverflow.com/questions/71093923/put-pdf-files-which-i-download-from-firebase-cloud-storage-to-recyclerview-using",
                ""
            ),
            PDFData(
                "Boys to Men",
                "What exactly in this code doesn't work the way you expect? Tell us what is wrong with shared code. Do you have any errors",
                "https://stackoverflow.com/questions/71093923/put-pdf-files-which-i-download-from-firebase-cloud-storage-to-recyclerview-using",
                ""
            ),
            PDFData(
                "Power of the mind",
                "What exactly in this code doesn't work the way you expect? Tell us what is wrong with shared code. Do you have any errors",
                "https://stackoverflow.com/questions/71093923/put-pdf-files-which-i-download-from-firebase-cloud-storage-to-recyclerview-using",
                ""
            ),
        )
    }

    //read pdfs,
    fun loadPdfs(prodkey: String?, level: String?, subject: String?, grade: String?) {
        pdfsReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var pdfArrayList = ArrayList<PDFData>()

                for (childSnapshot in dataSnapshot.children) {
                    val pdfs = childSnapshot.getValue(PDFData::class.java)
                    if (pdfs != null) {
                        if (pdfs.level == level && pdfs.subject == subject && pdfs.grade == grade)
                            pdfs.let { pdfArrayList.add(it) }
                    }
                }

                adapter = PdfAdapter(pdfArrayList, this@SyllabusMaterials)
                recyclerView.adapter = adapter
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle the error
            }
        })

    }

    override fun onPdfClick(pdf: PDFData, position: Int) {
        val intent = Intent(this, OpenMaterials::class.java)
        intent.putExtra("title", pdf.title)
        intent.putExtra("description", pdf.description)
        intent.putExtra("support", pdf.supportLink)
        intent.putExtra("pdfUrl", pdf.url)
        startActivity(intent)
    }
}