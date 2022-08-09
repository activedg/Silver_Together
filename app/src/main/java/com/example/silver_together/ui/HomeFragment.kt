package com.example.silver_together.ui

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.silver_together.R
import com.example.silver_together.adapter.HomeUserRVAdapter
import com.example.silver_together.base.BaseFragment
import com.example.silver_together.data.User
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
            rvHomeGroupPeople.apply {
                adapter = HomeUserRVAdapter().apply {
                    setData(initDummyData())
                }
                layoutManager = GridLayoutManager(context, 3, LinearLayoutManager.HORIZONTAL, false)
            }
            tvHomeGroupMore.setOnClickListener {
                (activity as MainActivity).setSelectedItem(0)
            }
        }
    }

    private fun initDummyData(): ArrayList<User>{
        val tempList = ArrayList<User>()
        tempList.apply {
            add(User("김민준", null))
            add(User("송지안", null))
            add(User("박우진", null))
            add(User("황지아", null))
            add(User("김지호", null))
            add(User("김서연", null))
        }
        return tempList
    }
}