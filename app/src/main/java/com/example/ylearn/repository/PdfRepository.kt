package com.example.ylearn.repository

class PdfRepository {

    @Volatile
    private var INSTANCE: PdfRepository? = null

    fun getInstance(): PdfRepository {
        return INSTANCE ?: synchronized(this) {
            val instance = PdfRepository()
            INSTANCE = instance
            instance
        }
    }


}