package com.example.ylearn

import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.github.barteksc.pdfviewer.PDFView
import java.io.BufferedInputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class ReadBookActivity : AppCompatActivity() {

    lateinit var pdfView: PDFView

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pdfView = findViewById(R.id.idPDFView)
        val receivedIntent = intent
        val pdfUrl = receivedIntent.getStringExtra("pdfURl")

        RetrievePDFFromURL(pdfView).execute(pdfUrl)
    }

    class RetrievePDFFromURL(pdfView: PDFView) :
        AsyncTask<String, Void, InputStream>() {
        val mypdfView: PDFView = pdfView

        override fun doInBackground(vararg params: String?): InputStream? {
            // on below line we are creating a variable for our input stream.
            var inputStream: InputStream? = null
            try {
                val url = URL(params.get(0))
                val urlConnection: HttpURLConnection = url.openConnection() as HttpsURLConnection
                if (urlConnection.responseCode == 200) {
                    inputStream = BufferedInputStream(urlConnection.inputStream)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                return null;
            }
            return inputStream;
        }

        override fun onPostExecute(result: InputStream?) {
            mypdfView.fromStream(result).load()

        }
    }

}
