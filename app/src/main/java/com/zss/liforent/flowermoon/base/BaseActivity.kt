package com.zss.liforent.flowermoon.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gyf.immersionbar.ImmersionBar
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir
import com.zss.liforent.flowermoon.base.utils.AppManager

abstract class BaseActivity : AppCompatActivity() {

    val loadService: LoadService<*> by lazy {
        LoadSir.getDefault().register(this) {
            reLoad()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        ImmersionBar.with(this).init()
        AppManager.instance.addActivity(this)
        initView()
        initEvent()
    }

    override fun onDestroy() {
        super.onDestroy()
        AppManager.instance.removeActivity(this)
    }

    abstract fun getLayoutId(): Int
    open fun initView() {}
    open fun initEvent() {}
    open fun reLoad() {}


}