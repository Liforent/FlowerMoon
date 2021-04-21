package com.zss.liforent.flowermoon.base.http

import com.zss.liforent.flowermoon.module.test.data.TestModel
import com.zss.liforent.flowermoon.module.test.data.TestResponse
import retrofit2.http.*

/**
 *
 *@Author:  Liforent
 *@CreateTime: 2021/04/19 17:01
 *@Descriptions:
 */
interface ApiService {

    @GET("/api/test/get")
    suspend fun testGet(
        @Header("Authorization") token: String,
        @Query("arg1") arg1: String?,
        @Query("arg2") arg2: Int?,
    ): BaseResponse<TestResponse>

    @POST("/api/test/post")
    suspend fun testPost(
        @Header("Authorization") token: String,
        @Body model:TestModel
    ): BaseResponse<TestResponse>

}