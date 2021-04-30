package com.zss.liforent.flowermoon.module.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zss.liforent.flowermoon.R
import com.zss.liforent.flowermoon.base.mvvm.BaseLifeCycleFragment
import com.zss.liforent.flowermoon.module.home.HomeViewModel
import androidx.lifecycle.Observer
import com.zss.liforent.flowermoon.base.utils.ZLog
import com.zss.liforent.flowermoon.base.utils.onResponse

/**
 *
 *@Author:  Liforent
 *@CreateTime: 2021/04/21 21:25
 *@Descriptions:
 */
class HomeChildCommonFragment : BaseLifeCycleFragment<HomeViewModel>() {
    override fun getLayoutId(): Int = R.layout.fragment_child_common


    override fun initView() {
        super.initView()
        mViewModel.getArticalList(0)
    }

    override fun initDataObserver() {
        mViewModel.mArticalListData.observe(this, {
            it.onResponse(mViewModel.loadState, {
                ZLog.e("fff"+it.data.datas.toString())
            }, {})
        })
    }
}