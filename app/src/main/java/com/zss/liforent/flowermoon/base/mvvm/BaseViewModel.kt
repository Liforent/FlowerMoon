package com.zss.liforent.flowermoon.base.mvvm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.zss.liforent.flowermoon.base.utils.ClassUtil

/**
 *
 *@Author:  Liforent
 *@CreateTime: 2021/04/19 17:52
 *@Descriptions:
 */
open class BaseViewModel<T:BaseRepository>(application: Application):AndroidViewModel(application) {
    val loadState by lazy {
        MutableLiveData<State>()
    }

    //通过反射注入mRepository
    val mRepository:T by lazy {
        // 获取对应Repository 实例 (有参构造函数)
        (ClassUtil.getClass<T>(this))
            // 获取构造函数的构造器，传入参数class
            .getDeclaredConstructor(MutableLiveData::class.java)
            // 传入加载状态
            .newInstance(loadState)
    }

    override fun onCleared() {
        super.onCleared()
        mRepository.unSubscribe()
    }

}