package com.zss.liforent.flowermoon.base.http

/**
 *
 *@Author:  Liforent
 *@CreateTime: 2021/04/23 9:42
 *@Descriptions:
 */
data class BaseWanAndroidPageResponse<T>(
        var data: Data<T>,
        var errorCode: Int,
        var errorMessage: String = ""
) {
    data class Data<T>(
            var curPage: Int,
            var datas: List<T>,
            var offset: Int,
            var over: Boolean,
            var pageCount: Int,
            var size: Int,
            var total: Int

    )
}
