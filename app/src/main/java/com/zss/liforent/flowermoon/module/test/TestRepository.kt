package com.zss.liforent.flowermoon.module.test

import com.zss.liforent.flowermoon.base.http.BaseResponse
import com.zss.liforent.flowermoon.base.mvvm.ApiRepository
import com.zss.liforent.flowermoon.base.mvvm.State
import com.zss.liforent.flowermoon.module.test.data.TestResponse

/**
 *
 *@Author:  Liforent
 *@CreateTime: 2021/04/20 20:08
 *@Descriptions:
 */
class TestRepository(var loadState:MutableList<State>):ApiRepository() {
    suspend fun testGet(
        token:String,
        arg1:String?,
        arg2:Int?
    ):BaseResponse<TestResponse>{
        return apiService.testGet(token,arg1,arg2)
    }
}