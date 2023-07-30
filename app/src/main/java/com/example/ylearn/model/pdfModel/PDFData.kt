package com.example.ylearn.model.pdfModel

data class PDFData(
    var title: String? = null,
    var description: String? = null,
    var supportLink: String? = null,
    var url: String? = null,
    val level:String?="",
    val subject:String?="",
    val grade:String?="",
)