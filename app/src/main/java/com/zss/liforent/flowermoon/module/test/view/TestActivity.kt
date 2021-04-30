package com.zss.liforent.flowermoon.module.test.view

import com.zss.liforent.flowermoon.R
import com.zss.liforent.flowermoon.base.mvvm.BaseLifeCycleActivity
import com.zss.liforent.flowermoon.base.utils.onResponse
import com.zss.liforent.flowermoon.module.test.TestViewModel

/**
 *
 *@Author:  Liforent
 *@CreateTime: 2021/04/20 20:37
 *@Descriptions:
 */
abstract class TestActivity : BaseLifeCycleActivity<TestViewModel>() {

//    private val mStateObserver = Observer<BaseResponse<TestResponse>> {
//        it.onResponse(loadState = 1, {}, {})
//    }



    override fun initDataObserver() {
        mViewModel.mTestData.observe(
            this, {
                it.onResponse(mViewModel.loadState , {

                }, {

                })

            }
        )
    }
}


