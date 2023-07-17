package com.example.ylearn.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.ylearn.adapter.VideoAdapter
import com.example.ylearn.databinding.FragmentVideoBinding
import com.example.ylearn.model.videoModel.VideoModel
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class VideoFragment : Fragment() {

    private var _binding: FragmentVideoBinding? = null
    private val binding get() = _binding!!

    lateinit var viewPager2: ViewPager2
    lateinit var adapter: VideoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentVideoBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val window = activity?.window

        /**set fullscreen*/
        window?.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        viewPager2 = binding.vpager

        /**set database*/
        val mDataBase = Firebase.database.getReference("videos")

        val options = FirebaseRecyclerOptions.Builder<VideoModel>()
            .setQuery(mDataBase, VideoModel::class.java)
            .build()
        /**set adapter*/
        adapter = VideoAdapter(options)
        viewPager2.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        adapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        adapter.stopListening()
    }
}