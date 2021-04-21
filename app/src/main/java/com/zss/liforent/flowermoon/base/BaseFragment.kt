package com.zss.liforent.flowermoon.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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

    val loadService: LoadService<*> by lazy {
        LoadSir.getDefault().register(this) {
            reLoad()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }


    open fun reLoad() {

    }

}