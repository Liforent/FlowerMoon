package com.zss.liforent.flowermoon.base.mvvm

/**
 *
 *@Author:  Liforent
 *@CreateTime: 2021/04/19 17:22
 *@Descriptions:
 */
enum class StateType {
    SUCCESS,
    ERROR,//接口请求成功，但是返回操作失败。（这部分的err_msg可能需要toast或者展示到ui）
    EMPTY,
    LOADING,
    RE_LOGIN,
    SYSTEM_ERROR//网络请求失败，服务器异常等
}