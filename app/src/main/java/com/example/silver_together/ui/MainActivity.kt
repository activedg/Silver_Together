package com.example.silver_together.ui

import com.example.silver_together.R
import com.example.silver_together.base.BaseActivity
import com.example.silver_together.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun initView() {
        binding.tvTest.text = "테스트"
    }
}