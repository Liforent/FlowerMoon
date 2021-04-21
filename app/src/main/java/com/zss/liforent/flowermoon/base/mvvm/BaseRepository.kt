
package com.zss.liforent.flowermoon.base.mvvm

import android.content.Context
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 *@Author liforent
 *@create 2020/8/24 18:19
 * 仓库对数据订阅事件进行管理
 */
open class BaseRepository() {
    private val mCompositeDisposable by lazy {
        CompositeDisposable()
    }
    //todo   测试下订阅的必要性，以及取代方案
    fun addSubscribe(disposable: Disposable) = mCompositeDisposable.add(disposable)
    fun unSubscribe() = mCompositeDisposable.dispose()
}