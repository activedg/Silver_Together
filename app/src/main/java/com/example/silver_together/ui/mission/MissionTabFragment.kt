package com.example.silver_together.ui.mission

import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.silver_together.R
import com.example.silver_together.adapter.MissionTabVPAdapter
import com.example.silver_together.base.BaseFragment
import com.example.silver_together.databinding.FragmentMissionTabBinding
import com.google.android.material.tabs.TabLayoutMediator

class MissionTabFragment : BaseFragment<FragmentMissionTabBinding>(R.layout.fragment_mission_tab) {
    private val information = listOf("방문", "활동", "식사")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTabLayout()
    }

    private fun initTabLayout(){
        binding.vpMission.apply {
            adapter = MissionTabVPAdapter(this@MissionTabFragment)
            registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    setTopLayout(position)
                }
            })
        }
        TabLayoutMediator(binding.tabMission, binding.vpMission){
            tab, position -> tab.text = information[position]
        }.attach()
    }

    private fun setTopLayout(position: Int) {
        with(binding) {
            when (position) {
                0 -> {
                    ivTabSummary.setImageResource(R.drawable.ic_mission_visit)
                    tvTabName.text = "방문"
                    tvTabDetail.text = resources.getString(R.string.visit_tab)
                }
                1 -> {
                    binding.ivTabSummary.setImageResource(R.drawable.ic_mission_activity)
                    binding.tvTabName.text = "활동"
                    tvTabDetail.text = resources.getString(R.string.activity_tab)
                }
                else -> {
                    binding.ivTabSummary.setImageResource(R.drawable.ic_mission_meat)
                    binding.tvTabName.text = "식당"
                    tvTabDetail.text = resources.getString(R.string.meal_tab)
                }
            }
        }
    }

}