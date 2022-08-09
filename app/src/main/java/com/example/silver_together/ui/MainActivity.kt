package com.example.silver_together.ui

import com.example.silver_together.R
import com.example.silver_together.base.BaseActivity
import com.example.silver_together.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun initView() {
        initBottomNavigation()
    }

    private fun initBottomNavigation(){
        // 메인 화면으로 시작
        goSelectedPage(1)
        binding.mainBottomNav.apply {
            itemActiveIndicatorColor = getColorStateList(R.color.color_st)
            selectedItemId = R.id.bottom_nav_main
            setOnItemSelectedListener {
                when(it.itemId){
                    R.id.bottom_nav_group -> {
                        goSelectedPage(0)
                        return@setOnItemSelectedListener true
                    }
                    R.id.bottom_nav_main -> {
                        goSelectedPage(1)
                        return@setOnItemSelectedListener true
                    }
                    R.id.bottom_nav_mission -> {
                        goSelectedPage(2)
                        return@setOnItemSelectedListener true
                    }
                    R.id.bottom_nav_setting -> {
                        goSelectedPage(3)
                        return@setOnItemSelectedListener true
                    }
                }
                false
            }
        }
    }

    private fun goSelectedPage(pageIdx: Int){
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm, when(pageIdx) {
                0 -> GroupFragment()
                1 -> HomeFragment()
                2 -> MissionFragment()
                else -> SettingFragment()
            }).commitAllowingStateLoss()
    }

    fun setSelectedItem(index: Int){
        binding.mainBottomNav.selectedItemId = when(index){
            0 -> R.id.bottom_nav_group
            1 -> R.id.bottom_nav_main
            2 -> R.id.bottom_nav_mission
            else -> R.id.bottom_nav_setting
        }
    }
}