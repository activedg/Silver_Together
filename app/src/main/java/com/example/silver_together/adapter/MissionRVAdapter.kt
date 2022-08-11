package com.example.silver_together.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.silver_together.R
import com.example.silver_together.data.Mission
import com.example.silver_together.databinding.ItemMissionBinding

class MissionRVAdapter : RecyclerView.Adapter<MissionRVAdapter.ViewHolder>() {
    private lateinit var binding: ItemMissionBinding
    private val missionList = ArrayList<Mission>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_mission, parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(missionList[position])
    }

    override fun getItemCount(): Int = missionList.size

    inner class ViewHolder(binding: ItemMissionBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(mission: Mission){
            with(binding){
                tvItemPlace.text = mission.place
                tvItemDetail.text = mission.detail
            }
        }
    }
}