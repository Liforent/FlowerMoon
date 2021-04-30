package com.zss.liforent.flowermoon.base.widget

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import org.jetbrains.anko.singleLine

/**
 *
 *@Author:  Liforent
 *@CreateTime: 2021/04/30 16:38
 *@Descriptions:跑马灯
 */
class MarqueeTextView : androidx.appcompat.widget.AppCompatTextView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attr: AttributeSet?) : super(context, attr)

    override fun isFocused(): Boolean {
        return true
    }

    init {
        singleLine = true
        ellipsize = TextUtils.TruncateAt.MARQUEE
    }
}