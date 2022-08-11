package com.example.silver_together.ui.home

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.silver_together.R
import com.example.silver_together.adapter.HomeUserRVAdapter
import com.example.silver_together.base.BaseFragment
import com.example.silver_together.data.User
import com.example.silver_together.databinding.FragmentHomeBinding
import com.example.silver_together.ui.MainActivity

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
                adapter = HomeUserRVAdapter(getScreenWidth()/ 2).apply {
                    setData(initDummyData())
                }
                layoutManager = GridLayoutManager(context, 3, LinearLayoutManager.HORIZONTAL, false)
            }
            tvHomeGroupMore.setOnClickListener {
                (activity as MainActivity).setSelectedItem(1)
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

    private fun getScreenWidth(): Int{
        val wm = activity?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val size = wm.currentWindowMetrics
            val deviceWidth = size.bounds.width()
            deviceWidth
        } else {
            val displayMetrics = DisplayMetrics()
            wm.defaultDisplay.getMetrics(displayMetrics)
            displayMetrics.widthPixels
        }
    }
}