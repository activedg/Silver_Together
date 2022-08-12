package com.example.silver_together.ui.mission

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.silver_together.R
import com.example.silver_together.adapter.MissionRVAdapter
import com.example.silver_together.base.BaseFragment
import com.example.silver_together.data.Mission
import com.example.silver_together.databinding.FragmentMissionActivityBinding
import java.util.ArrayList

class MissionActivityFragment : BaseFragment<FragmentMissionActivityBinding>(R.layout.fragment_mission_activity){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView(){
        with(binding){
            rvVisitTogether.adapter = MissionRVAdapter().apply {
                setData(ArrayList<Mission>().apply {
                    add(Mission("까망돌 도서관", "흑석동의 대표 도서관", R.drawable.ic_library1))
                    add(Mission("고구 동산", "흑석동의 공원이자\n서울의 야경 명소", R.drawable.ic_gogu))
                })
            }
            rvVisitTogether.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

            rvVisitRecommend.adapter = MissionRVAdapter().apply {
                setData(ArrayList<Mission>().apply {
                    add(Mission("흑석 체육 센터", "탁 트인 한강이 보이는\n종합 운동 시설", R.drawable.ic_gym))
                    add(Mission("김영삼 도서관", "상도동의 대표 도서관", R.drawable.ic_library2))
                })
            }
            rvVisitRecommend.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }
}