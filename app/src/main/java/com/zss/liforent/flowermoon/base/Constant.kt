package com.zss.liforent.flowermoon.base

object Constant {
    const val isDebug = true
    private const val RELEASE_DOMAIN = "https://www.wanandroid.com"
    private const val DEBUG_DOMAIN = "https://www.wanandroid.com"
    var DOMAIN = if(isDebug) DEBUG_DOMAIN else RELEASE_DOMAIN

    const val TAB_HOME = 0
    const val TAB_DISCOVERIES = 1
    const val TAB_MESSAGES = 2
    const val TAB_MINE = 3

    //后台返回数据，1为成功。
    const val CODE_SUCCESS = 1
    const val CODE_NOT_LOGIN = -1001

}