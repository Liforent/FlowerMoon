package com.zss.liforent.flowermoon.base.mvvm

import androidx.lifecycle.Observer
import com.kingja.loadsir.callback.SuccessCallback
import com.kingja.loadsir.core.LoadService
import com.zss.liforent.flowermoon.base.BaseActivity
import com.zss.liforent.flowermoon.base.loadSir.EmptyCallback
import com.zss.liforent.flowermoon.base.loadSir.LoadingCallback
import com.zss.liforent.flowermoon.base.utils.ClassUtil
import org.jetbrains.anko.toast

/**
 *
 *@Author:  Liforent
 *@CreateTime: 2021/04/19 21:06
 *@Descriptions:
 *  loadSir:默认开启loadSir,也就是进入Activity后
 *
 *
 */
abstract class BaseLifeCycleActivity<VM:BaseViewModel<*>>:BaseActivity() {
    protected lateinit var mViewModel:VM
    protected lateinit var mLoadService: LoadService<*>
    var isLoading = true
    var isOpenLoadSir = true
    private val mStateObserver = Observer<State>{
        it?.let {
            when(it.code){
                StateType.LOADING->{
                    isLoading = true
                }
                StateType.SUCCESS->{
                    showSuccessCallback()
                }
                StateType.EMPTY->{
                    showEmptyCallback()
                }
                StateType.ERROR->{

                }
                StateType.RE_LOGIN->{

                }
                StateType.SYSTEM_ERROR->{

                }

            }
        }
    }

    override fun initView() {
        super.initView()
        mViewModel =defaultViewModelProviderFactory.create(ClassUtil.getClass(this))
        mViewModel.loadState.observe(this,mStateObserver)
        initDataObserver()
        showSuccessCallback()
    }

    abstract fun initDataObserver()


    open fun showEmptyCallback() {
        mLoadService.showCallback(EmptyCallback::class.java)
    }

    open fun showSuccessCallback() {
        mLoadService.showCallback(SuccessCallback::class.java)
    }

    open fun showLoadingCallback() {
        mLoadService.showCallback(LoadingCallback::class.java)
    }

    open fun showErrorMsg(msg: String) {
        mLoadService.showCallback(SuccessCallback::class.java)
        toast(msg)
    }

    open fun showSystemErrorMsg(msg: String) {
        toast(msg)
        mLoadService.showSuccess()
    }
}