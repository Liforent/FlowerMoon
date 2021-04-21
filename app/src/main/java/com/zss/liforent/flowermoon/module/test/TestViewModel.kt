package com.zss.liforent.flowermoon.module.test

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.zss.liforent.flowermoon.base.http.ApiList
import com.zss.liforent.flowermoon.base.http.BaseResponse
import com.zss.liforent.flowermoon.base.mvvm.BaseViewModel
import com.zss.liforent.flowermoon.base.utils.initialRequest
import com.zss.liforent.flowermoon.module.test.data.TestResponse

/**
 *
 *@Author:  Liforent
 *@CreateTime: 2021/04/20 20:18
 *@Descriptions:
 */
class TestViewModel(application: Application) : BaseViewModel<TestRepository>(application) {
    val mTestData: MutableLiveData<BaseResponse<TestResponse>> = MutableLiveData()

    fun testGet(
        token: String,
        name: String?,
        id: Int?
    ) {
        initialRequest({
            mTestData.value = mRepository.testGet(token, name, id)
        }, loadState, ApiList.LOGIN)
    }
}