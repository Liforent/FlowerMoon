package com.zss.liforent.flowermoon.activity

import android.content.Intent
import android.view.LayoutInflater
import com.zss.liforent.flowermoon.R
import com.zss.liforent.flowermoon.base.BaseActivity
import com.zss.liforent.flowermoon.databinding.ActivityAppStartBinding

/**
 *
 *@Author:  Liforent
 *@CreateTime: 2021/04/20 15:59
 *@Descriptions:
 */
class AppStartActivity : BaseActivity() {
    override fun getLayoutId(): Int = R.layout.activity_app_start


    override fun initView() {
        super.initView()
        goToMain()
    }

    private fun goToMain() {
        startActivity(Intent(this, MainActivity::class.java))
    }

}