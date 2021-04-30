package com.zss.liforent.flowermoon.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

/**
 *
 *@Author:  Liforent
 *@CreateTime: 2021/04/23 10:19
 *@Descriptions:
 */
class BaseFragmentStateAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    private val mFragments = mutableListOf<Fragment>()

    override fun getCount(): Int {
        return mFragments.size
    }

    override fun getItem(position: Int): Fragment {
        return mFragments[position]
    }

    fun add(fragment: Fragment) {
        mFragments.add(fragment)
    }
}