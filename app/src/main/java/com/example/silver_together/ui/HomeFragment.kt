package com.example.silver_together.ui

import android.os.Bundle
import android.view.View
import com.example.silver_together.R
import com.example.silver_together.base.BaseFragment
import com.example.silver_together.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView(){
        with(binding){
            tvHomeMissionMore.setOnClickListener {
                (activity as MainActivity).setSelectedItem(2)
            }
        }
    }
}