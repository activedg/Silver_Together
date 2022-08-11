package com.example.silver_together.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.silver_together.R
import com.example.silver_together.databinding.FragmentMissionTabBinding
import com.example.silver_together.ui.mission.MissionActivityFragment
import com.example.silver_together.ui.mission.MissionMeatFragment
import com.example.silver_together.ui.mission.MissionVisitFragment

class MissionTabVPAdapter(fragment: Fragment) : FragmentStateAdapter(fragment){
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> MissionVisitFragment()
            1 -> MissionActivityFragment()
            else -> MissionMeatFragment()
        }
    }
}