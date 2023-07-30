package com.example.ylearn.pdfViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ylearn.model.pdfModel.PDFData
import com.google.firebase.database.*
import timber.log.Timber

class PdfViewModel : ViewModel() {

    private val databaseReference: DatabaseReference =
        FirebaseDatabase.getInstance().getReference("pdfs")

    //    private val repository: PdfRepository = PdfRepository().getInstance()
    private val _allPdfs = MutableLiveData<List<PDFData>>()
    val allPdfs: LiveData<List<PDFData>> = _allPdfs

    init {
        loadPdfs()
    }

    fun loadPdfs() {
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                try {

                    _allPdfs.postValue(snapshot.children.map { dataSnapshot ->
                        Timber.e(dataSnapshot.getValue(PDFData::class.java)!!.toString())
                        dataSnapshot.getValue(PDFData::class.java)!!

                    })


                } catch (_: Exception) {
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }

}