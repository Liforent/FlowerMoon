package com.zss.liforent.flowermoon.module.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.zss.liforent.flowermoon.base.mvvm.BaseLifeCycleFragment
import com.zss.liforent.flowermoon.module.home.HomeViewModel
import com.zss.liforent.flowermoon.R
import com.zss.liforent.flowermoon.base.BaseFragmentStateAdapter
import kotlinx.android.synthetic.main.fragment_home.*


/**
 *
 *@Author:  Liforent
 *@CreateTime: 2021/04/21 21:01
 *@Descriptions:
 */
class HomeFragment : BaseLifeCycleFragment<HomeViewModel>() {

    private lateinit var mFragmentAdapter: BaseFragmentStateAdapter
    override fun getLayoutId(): Int = R.layout.fragment_home
    override fun initDataObserver() {

    }



    override fun initView() {
        super.initView()
        view_pager2.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = 3

            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> HomeChildCommonFragment()
                    1 -> HomeChildCommonFragment()
                    else -> HomeChildCommonFragment()
                }
            }
        }
        TabLayoutMediator(tab_layout, view_pager2) { tab, position ->

            when (position) {
                0 -> tab.text = "0"
                1 -> tab.text = "1"
                else -> tab.text = "2"
            }

        }.attach()


    }

    override fun initEvent() {
        super.initEvent()
    }
}