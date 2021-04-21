package com.zss.liforent.flowermoon.base.mvvm

import com.zss.liforent.flowermoon.base.http.ApiService
import com.zss.liforent.flowermoon.base.http.RetrofitFactory

/**
 *
 *@Author:  Liforent
 *@CreateTime: 2021/04/19 16:31
 *@Descriptions:
 */
open class ApiRepository:BaseRepository() {
    val apiService:ApiService by lazy {
        RetrofitFactory.instance.create(ApiService::class.java)
    }
}