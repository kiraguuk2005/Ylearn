package com.example.ylearn.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ylearn.JuniorSecondary
import com.example.ylearn.Primary
import com.example.ylearn.SeniorSecondary
import com.example.ylearn.UnderGraduate
import com.example.ylearn.databinding.FragmentAiBinding


class AiFragment : Fragment() {

    private var _binding: FragmentAiBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAiBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnPrimary.setOnClickListener {
            val intent = Intent(requireActivity(), Primary::class.java)
            startActivity(intent)
        }

        binding.btnJuniorSec.setOnClickListener {
            val intent = Intent(requireActivity(), JuniorSecondary::class.java)
            startActivity(intent)
        }

        binding.btnSeniorSec.setOnClickListener {
            val intent = Intent(requireActivity(), SeniorSecondary::class.java)
            startActivity(intent)
        }
        binding.btnUnderGrad.setOnClickListener {
            val intent = Intent(requireActivity(), UnderGraduate::class.java)
            startActivity(intent)
        }

    }


}