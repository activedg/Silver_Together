package com.example.silver_together.ui.mission

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.silver_together.R
import com.example.silver_together.adapter.MissionRVAdapter
import com.example.silver_together.base.BaseFragment
import com.example.silver_together.data.Mission
import com.example.silver_together.databinding.FragmentMissionMeatBinding
import java.util.ArrayList

class MissionMeatFragment : BaseFragment<FragmentMissionMeatBinding>(R.layout.fragment_mission_meat) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView(){
        with(binding){
            rvMeatTogether.adapter = MissionRVAdapter().apply {
                setData(ArrayList<Mission>().apply {
                    add(Mission("온희네 온집닭떡볶이", "한식", "동작구 상도동 17-61", R.drawable.ic_meat1))
                    add(Mission("명동국수", "국수 전문점", "동작구 상도동 상도로\n41길 12", R.drawable.ic_meat2))
                })
            }
            rvMeatTogether.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

            rvMeatRecommend.adapter = MissionRVAdapter().apply {
                setData(ArrayList<Mission>().apply {
                    add(Mission("다래식당", "한식", "동작구 상도동 17-61", R.drawable.ic_meat3))
                    add(Mission("빽진라면", "일본라면 전문식당", "동작구 상도동 상도로\n295", R.drawable.ic_meat4))
                })
            }
            rvMeatRecommend.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }
}