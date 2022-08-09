package com.example.silver_together.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.silver_together.R
import com.example.silver_together.data.User
import com.example.silver_together.databinding.ItemUserBinding

class HomeUserRVAdapter() : RecyclerView.Adapter<HomeUserRVAdapter.ViewHolder>() {
    private var userList = ArrayList<User>()
    private lateinit var binding: ItemUserBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_user, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    fun setData(data: ArrayList<User>){
        userList = data
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = userList.size

    inner class ViewHolder(binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User){
            with(binding){
                user.imgRes?.let { ivItemUserProfile.setImageResource(it) }
                tvItemUserName.text = user.name
            }
        }

    }
}