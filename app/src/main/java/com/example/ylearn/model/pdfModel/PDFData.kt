package com.example.ylearn.model.pdfModel

data class PDFData(
    val image: Int,
    var title: String? = null,
    var description: String? = null,
    var supportLink: String? = null,
    var url: String? = null
)