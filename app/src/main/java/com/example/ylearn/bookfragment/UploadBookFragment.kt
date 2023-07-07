package com.example.ylearn.bookfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.ylearn.R
import com.example.ylearn.databinding.FragmentUploadBookBinding

class UploadBookFragment : Fragment() {
    private var _binding: FragmentUploadBookBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUploadBookBinding.inflate(inflater, container, false)

        val bookCategory = resources.getStringArray(R.array.bookCategory)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.list_item, bookCategory)
        binding.autoComplete.setAdapter(arrayAdapter)


        val bookLevel = resources.getStringArray(R.array.bookLevel)
        val arrayAdapter2 = ArrayAdapter(requireContext(), R.layout.list_item, bookLevel)
        binding.autoComplete2.setAdapter(arrayAdapter2)


        return binding.root
    }

}

