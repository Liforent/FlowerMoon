package com.zss.liforent.flowermoon.activity

import android.util.SparseArray
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import com.zss.liforent.flowermoon.R
import com.zss.liforent.flowermoon.base.BaseActivity
import com.zss.liforent.flowermoon.base.Constant
import com.zss.liforent.flowermoon.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private var mFragmentSparseArray = SparseArray<Fragment>()
    private var mExitTime = 0L
    private var mCurrentFragment: Fragment? = null
    private lateinit var binding: ActivityMainBinding

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initView() {
        super.initView()
        binding = ActivityMainBinding.inflate(layoutInflater)
        initNavView()
        switchFragment(Constant.TAB_HOME)
    }


    private fun initNavView() {
        binding.bottomNavView.apply {
            //取消导航栏着色
            itemIconTintList = null
            //图标和文字同时显示
            labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED
            setOnNavigationItemSelectedListener { item: MenuItem ->

                if (item.itemId == binding.bottomNavView.selectedItemId) {
                    return@setOnNavigationItemSelectedListener false
                }
                when (item.itemId) {
                    R.id.navigation_home -> {
                        switchFragment(Constant.TAB_HOME)
                        return@setOnNavigationItemSelectedListener true
                    }
                    R.id.navigation_discoveries -> {
                        switchFragment(Constant.TAB_DISCOVERIES)
                        return@setOnNavigationItemSelectedListener true
                    }
                    R.id.navigation_messages -> {
                        switchFragment(Constant.TAB_MESSAGES)
                        return@setOnNavigationItemSelectedListener true
                    }
                    R.id.navigation_mine -> {
                        switchFragment(Constant.TAB_MINE)
                        return@setOnNavigationItemSelectedListener true
                    }
                    else -> return@setOnNavigationItemSelectedListener false
                }
            }
        }
    }

    private fun switchFragment(position: Int) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        mCurrentFragment = fragmentManager.findFragmentByTag(position.toString())
        hideAll(transaction)
        if (mCurrentFragment == null) {
            mCurrentFragment = getFragment(position)
            transaction.add(R.id.fragment_page, mCurrentFragment!!, position.toString())
        } else {
            transaction.show(mCurrentFragment!!)
        }
    }

    private fun getFragment(position: Int): Fragment {
        var fragment: Fragment? = mFragmentSparseArray.get(position)
        if (fragment == null) {
            when (position) {
                Constant.TAB_HOME -> fragment = Fragment()
                Constant.TAB_DISCOVERIES -> fragment = Fragment()
                Constant.TAB_MESSAGES -> fragment = Fragment()
                Constant.TAB_MINE -> fragment = Fragment()
            }
            mFragmentSparseArray.put(position, fragment)
        }
        return fragment!!
    }

    private fun hideAll(transaction: FragmentTransaction) {
        supportFragmentManager.fragments.forEach {
            transaction.hide(it)
        }
    }
}