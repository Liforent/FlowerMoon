package com.zss.liforent.flowermoon.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gyf.immersionbar.ImmersionBar
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir

/**
 *
 *@Author:  Liforent
 *@CreateTime: 2021/04/21 20:02
 *@Descriptions:
 */
abstract class BaseFragment : Fragment() {

    val mContext by lazy {
        requireActivity()
    }

    lateinit var mLoadService: LoadService<*>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(getLayoutId(), null)
        mLoadService = LoadSir.getDefault().register(rootView) { reLoad() }
        return mLoadService.loadLayout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ImmersionBar.with(this).init()
        mLoadService.showSuccess()
        initView()
        initEvent()
    }

    abstract fun getLayoutId(): Int
    open fun reLoad() {}
    open fun initView(){}
    open fun initEvent(){}

}