package com.zss.liforent.flowermoon.base.loadSir

import com.kingja.loadsir.callback.Callback
import com.zss.liforent.flowermoon.R

/**
 *
 *@Author:  Liforent
 *@CreateTime: 2021/04/19 21:29
 *@Descriptions:
 */
class LoadingCallback :Callback(){
    override fun onCreateView(): Int = R.layout.layout_loading
}