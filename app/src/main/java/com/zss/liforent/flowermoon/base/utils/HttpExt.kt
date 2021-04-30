package com.zss.liforent.flowermoon.base.utils

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.zss.liforent.flowermoon.base.Constant
import com.zss.liforent.flowermoon.base.http.BaseResponse
import com.zss.liforent.flowermoon.base.http.BaseWanAndroidPageResponse
import com.zss.liforent.flowermoon.base.mvvm.BaseRepository
import com.zss.liforent.flowermoon.base.mvvm.BaseViewModel
import com.zss.liforent.flowermoon.base.mvvm.State
import com.zss.liforent.flowermoon.base.mvvm.StateType
import kotlinx.coroutines.launch

/**
 *
 *@Author:  Liforent
 *@CreateTime: 2021/04/20 20:21
 *@Descriptions:
 */

fun <T : BaseRepository> BaseViewModel<T>.initialRequest(
    block: suspend () -> Unit,
    loadState: MutableLiveData<State>,
    apiCode: Int
) {
    viewModelScope.launch {
        runCatching {
            loadState.postValue(State(StateType.LOADING))
            block()
        }.onFailure {
            Log.e("err", apiCode.toString())
        }
    }
}


fun <T> BaseResponse<T>.onResponse(
    loadState: MutableLiveData<State>,
    onSuccess: () -> Unit
) {
    when (this.code) {
        Constant.CODE_SUCCESS -> {
            if (this.data is List<*>) {
                if ((this.data as List<*>).isEmpty()) {
                    loadState.postValue(State(StateType.EMPTY))
                    ZLog.d("StateType.EMPTY")
                    return
                }
            }
            loadState.postValue(State(StateType.SUCCESS))
            onSuccess()
            ZLog.d("StateType.SUCCESS,data:" + this.data.toString())
        }
        Constant.CODE_NOT_LOGIN -> {
            loadState.postValue(State(StateType.RE_LOGIN, msg = "请重新登录"))
            ZLog.d("StateType.RE_LOGIN")
        }
        else -> {
            ZLog.e("StateType.ERROR" + this.msg?.toString())
            if (this.msg != null) {
                loadState.postValue(State(StateType.ERROR, msg = this.msg))
            } else {
                loadState.postValue(
                    State(
                        StateType.ERROR,
                        msg = "请求失败code=${this.code}msg=null"
                    )
                )
            }
        }
    }
}



fun <T> BaseResponse<T>.onResponse(
    loadState: MutableLiveData<State>,
    onSuccess: () -> Unit,
    onError: () -> Unit
) {
    when (this.code) {
        Constant.CODE_SUCCESS -> {
            if (this.data is List<*>) {
                if ((this.data as List<*>).isEmpty()) {
                    loadState.postValue(State(StateType.EMPTY))
                    ZLog.d("StateType.EMPTY")
                    return
                }
            }
            loadState.postValue(State(StateType.SUCCESS))
            onSuccess()
            ZLog.d("StateType.SUCCESS,data:"+this.data.toString())

        }
        Constant.CODE_NOT_LOGIN -> {
            loadState.postValue(State(StateType.RE_LOGIN, msg = "请重新登录"))
            ZLog.d("StateType.RE_LOGIN")

        }
        else -> {
            onError()
            ZLog.e("StateType.ERROR" + this.msg?.toString())
            if (this.msg != null) {
                loadState.postValue(State(StateType.ERROR, msg = this.msg))
            } else {
                loadState.postValue(
                    State(
                        StateType.ERROR,
                        msg = "请求失败code=${this.code}msg=null"
                    )
                )
            }
        }
    }


}



fun <T> BaseWanAndroidPageResponse<T>.onResponse(
        loadState: MutableLiveData<State>,
        onSuccess: () -> Unit,
        onError: () -> Unit
) {
    when (this.errorCode) {
        Constant.CODE_SUCCESS -> {
            if (this.data is List<*>) {
                if ((this.data as List<*>).isEmpty()) {
                    loadState.postValue(State(StateType.EMPTY))
                    ZLog.d("StateType.EMPTY")
                    return
                }
            }
            loadState.postValue(State(StateType.SUCCESS))
            onSuccess()
            ZLog.d("StateType.SUCCESS,data:"+this.data.toString())

        }
        Constant.CODE_NOT_LOGIN -> {
            loadState.postValue(State(StateType.RE_LOGIN, msg = "请重新登录"))
            ZLog.d("StateType.RE_LOGIN")

        }
        else -> {
            onError()
            ZLog.e("StateType.ERROR" + this.errorMessage?.toString())
            if (this.errorMessage != null) {
                loadState.postValue(State(StateType.ERROR, msg = this.errorMessage))
            } else {
                loadState.postValue(
                        State(
                                StateType.ERROR,
                                msg = "请求失败code=${this.errorCode}msg=null"
                        )
                )
            }
        }
    }


}




fun String.getApiCode(): String {
    return if (this.length >= 6) {
        this.substring(this.length - 5, this.length-1)
    } else {
        ""
    }

}