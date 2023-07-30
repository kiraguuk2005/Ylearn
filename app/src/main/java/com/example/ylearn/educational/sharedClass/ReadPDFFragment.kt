package com.example.ylearn.educational.sharedClass

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.ylearn.R

private const val pdfURl = "pdfURl"

class ReadPDFFragment : Fragment() {

    private var pdfURll: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            pdfURll = it.getString(pdfURl)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_read_p_d_f, container, false)
        pdfURll?.let { showToast(it) }
    }

    private fun showToast(it: String) {
        Toast.makeText(context, it, Toast.LENGTH_SHORT).show()

    }

}