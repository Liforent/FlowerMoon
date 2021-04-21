package com.zss.liforent.flowermoon.base.utils

import java.lang.reflect.ParameterizedType

/**
 *
 *@Author:  Liforent
 *@CreateTime: 2021/04/19 17:54
 *@Descriptions:
 */
object ClassUtil {
    @Suppress("UNCHECKED_CAST")
    fun <T> getClass(t: Any): Class<T> {
        // 通过反射 获取父类泛型 (T) 对应 Class类

        return (t.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<T>

//        return if(t is BaseScannerActivity){
//            (BaseScannerActivity::class.java.genericSuperclass as ParameterizedType).actualTypeArguments[0]
//                    as Class<T>
//        } else{
//            (t.javaClass.genericSuperclass as ParameterizedType)
//                .actualTypeArguments[0]
//                    as Class<T>
//        }
    }
}