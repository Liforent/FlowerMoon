package com.zss.liforent.flowermoon.base.http

/**
 *
 *@Author:  Liforent
 *@CreateTime: 2021/04/19 17:03
 *@Descriptions:
 */
open class BaseResponse<T>(var data: T, var code: Int = -1, var msg: String = "")