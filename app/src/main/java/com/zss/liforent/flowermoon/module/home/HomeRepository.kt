package com.zss.liforent.flowermoon.module.home

import androidx.lifecycle.MutableLiveData
import com.zss.liforent.flowermoon.base.mvvm.ApiRepository
import com.zss.liforent.flowermoon.base.mvvm.BaseRepository
import com.zss.liforent.flowermoon.base.mvvm.State

/**
 *
 *@Author:  Liforent
 *@CreateTime: 2021/04/20 19:58
 *@Descriptions:
 */
class HomeRepository(var loadState:MutableLiveData<State>): ApiRepository() {

}