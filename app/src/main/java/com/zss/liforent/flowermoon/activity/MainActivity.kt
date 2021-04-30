package com.zss.liforent.flowermoon.activity

import android.util.SparseArray
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import com.zss.liforent.flowermoon.R
import com.zss.liforent.flowermoon.base.BaseActivity
import com.zss.liforent.flowermoon.base.Constant
import com.zss.liforent.flowermoon.module.home.view.HomeFragment
import com.zss.liforent.flowermoon.module.test.view.TestFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    private var mFragmentSparseArray = SparseArray<Fragment>()
    private var mExitTime = 0L
    private var mCurrentFragment: Fragment? = null
    override fun getLayoutId(): Int = R.layout.activity_main


    override fun initView() {
        super.initView()
        initNavView()
        switchFragment(Constant.TAB_HOME)
    }


    private fun initNavView() {
        bottom_nav_view.apply {
            //取消导航栏着色
            itemIconTintList = null
            //图标和文字同时显示
            labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED
            setOnNavigationItemSelectedListener { item: MenuItem ->

                if (item.itemId == bottom_nav_view.selectedItemId) {
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
        if (mCurrentFragment == null) {
            mCurrentFragment = getFragment(position)
            hideAll(transaction)
            transaction.add(R.id.fragment_page, mCurrentFragment!!, position.toString())
        } else {
            hideAll(transaction)
            transaction.show(mCurrentFragment!!)
        }
        transaction.commit()

    }

    private fun getFragment(position: Int): Fragment {
        var fragment: Fragment? = mFragmentSparseArray.get(position)
        if (fragment == null) {
            when (position) {
                Constant.TAB_HOME -> fragment = HomeFragment()
                Constant.TAB_DISCOVERIES -> fragment = TestFragment()
                Constant.TAB_MESSAGES -> fragment = TestFragment()
                Constant.TAB_MINE -> fragment = TestFragment()
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