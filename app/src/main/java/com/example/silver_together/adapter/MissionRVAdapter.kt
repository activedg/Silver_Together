package com.example.silver_together.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.silver_together.R
import com.example.silver_together.data.Mission
import com.example.silver_together.databinding.ItemMissionBinding


class MissionRVAdapter : RecyclerView.Adapter<MissionRVAdapter.ViewHolder>() {
    private lateinit var binding: ItemMissionBinding
    private var missionList = ArrayList<Mission>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_mission, parent,false)
        val layoutParams: ViewGroup.LayoutParams = binding.root.layoutParams
        layoutParams.width = (parent.width - 50)/ 2
        binding.root.layoutParams = layoutParams
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(missionList[position])
    }

    fun setData(data: ArrayList<Mission>){
        missionList = data
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = missionList.size

    inner class ViewHolder(binding: ItemMissionBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(mission: Mission){
            with(binding){
                tvItemPlace.text = mission.place
                tvItemDetail.text = mission.detail
                ivItemMission.setImageResource(mission.imageRes)
                if (mission.meatPlace == null) tvItemRoadPlace.visibility = View.INVISIBLE
                else tvItemRoadPlace.text = mission.meatPlace
            }
        }
    }
}