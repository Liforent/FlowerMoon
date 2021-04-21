package com.zss.liforent.flowermoon.base.loadSir

import com.kingja.loadsir.callback.Callback
import com.zss.liforent.flowermoon.R

/**
 *
 *@Author:  Liforent
 *@CreateTime: 2021/04/19 21:26
 *@Descriptions:
 */
class EmptyCallback: Callback() {
    override fun onCreateView(): Int= R.layout.layout_empty
}