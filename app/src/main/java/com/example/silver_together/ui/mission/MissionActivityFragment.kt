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
            rvActivityTogether.adapter = MissionRVAdapter().apply {
                setData(ArrayList<Mission>().apply {
                    add(Mission("2018 하반기 독서정담", "치매예방 독서 프로그램\n서울도서관", null, R.drawable.ic_read))
                    add(Mission("특수판매 피해예방교육", "다단계 사기 피해 방지교육\n서울노인복지센터", null, R.drawable.ic_edu))
                })
            }
            rvActivityTogether.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

            rvActivityRecommend.adapter = MissionRVAdapter().apply {
                setData(ArrayList<Mission>().apply {
                    add(Mission("산책", "어디든 좋아요,\n팀원들과 함께 걸어요", null, R.drawable.ic_walk))
                    add(Mission("무료 심리상담", "당신의 고민을 풀어내세요\n상도1동 경로당", null, R.drawable.ic_test))
                })
            }
            rvActivityRecommend.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }
}