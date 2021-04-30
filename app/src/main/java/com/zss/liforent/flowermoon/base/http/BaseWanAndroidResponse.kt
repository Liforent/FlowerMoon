package com.zss.liforent.flowermoon.base.http

/**
 *
 *@Author:  Liforent
 *@CreateTime: 2021/04/23 9:38
 *@Descriptions:
 */
data class BaseWanAndroidResponse<T>(var data: T, var errorCode: Int, var errorMsg: String="")
