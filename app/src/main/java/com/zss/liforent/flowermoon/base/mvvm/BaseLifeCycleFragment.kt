package com.zss.liforent.flowermoon.base.mvvm

import android.widget.Toast
import androidx.lifecycle.Observer
import com.kingja.loadsir.callback.SuccessCallback
import com.zss.liforent.flowermoon.base.BaseFragment
import com.zss.liforent.flowermoon.base.loadSir.EmptyCallback
import com.zss.liforent.flowermoon.base.loadSir.LoadingCallback
import com.zss.liforent.flowermoon.base.utils.ClassUtil

/**
 *
 *@Author:  Liforent
 *@CreateTime: 2021/04/21 20:43
 *@Descriptions:
 */
abstract class BaseLifeCycleFragment<VM : BaseViewModel<*>> : BaseFragment() {
    lateinit var mViewModel: VM
    private val mObserver = Observer<State> {
        it?.let { initSateObserver(it) }
    }

    override fun initView() {
        super.initView()
        mViewModel = defaultViewModelProviderFactory.create(ClassUtil.getClass(this))
        mViewModel.loadState.observe(this, mObserver)
        initDataObserver()

    }
    abstract fun initDataObserver()
    private fun initSateObserver(state: State) {
        when(state.code){
            StateType.SUCCESS -> {
                //closeLoadingPop()
                showSuccessCallback()
            }
            StateType.LOADING -> {
//                isLoading = true
//                view?.postDelayed({
//                    if (isLoading && isShowLoadingView) {
//                        showLoadingPop()
//                    }
//                }, 500)
            }

            StateType.EMPTY -> {
                //closeLoadingPop()
                showEmpty()
            }
            StateType.RE_LOGIN -> {
                //closeLoadingPop()
                //startActivity(Intent(activity, LoginActivity::class.java))
            }
            StateType.ERROR -> {
                //closeLoadingPop()
                //showErrorMsg(it.msg)
            }
            StateType.SYSTEM_ERROR -> {
                //closeLoadingPop()
                //showSystemErrorMsg(it.msg)
            }
        }
    }


    public fun showLoadingView() {
        //isShowLoadingView = true
    }

    open fun showLoadingCallback() {
        mLoadService.showCallback(LoadingCallback::class.java)
    }

    open fun showSuccessCallback() {
        mLoadService.showCallback(SuccessCallback::class.java)
    }

    open fun showEmpty() {
        mLoadService.showCallback(EmptyCallback::class.java)
    }

    open fun showErrorMsg(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        showSuccessCallback()
    }
    //系统错误，默认只toast，如果需要展示ErrorCallback,重写之
    open fun showSystemErrorMsg(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        showSuccessCallback()
    }
}