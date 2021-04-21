package com.zss.liforent.flowermoon.base.utils

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*
import kotlin.system.exitProcess

/**
 *
 *@Author:  Liforent
 *@CreateTime: 2021/04/20 16:03
 *@Descriptions:Activity管理类
 */
class AppManager {
    companion object {
        val instance by lazy {
            AppManager()
        }
    }

    private val mActivityStack: Stack<Activity> = Stack()

    fun addActivity(activity: Activity){
        mActivityStack.add(activity)
    }

    fun removeActivity(activity: Activity){
        mActivityStack.remove(activity)
    }

    private fun finishAllActivity(){
        for(activity in mActivityStack){
            activity.finish()
        }
        mActivityStack.clear()
    }

    fun exitApp(context:Context){
        finishAllActivity()
        val mActivityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        mActivityManager.killBackgroundProcesses(context.packageName)
        exitProcess(0)
    }

}