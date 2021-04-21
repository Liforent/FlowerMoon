package com.zss.liforent.flowermoon.base.http

import com.zss.liforent.flowermoon.base.Constant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *
 *@Author:  Liforent
 *@CreateTime: 2021/04/19 17:05
 *@Descriptions:
 */
class RetrofitFactory private constructor() {
    companion object {
        val instance by lazy {
            RetrofitFactory()
        }
    }

    private val retrofit: Retrofit
    fun <T> create(clazz: Class<T>): T {
        return retrofit.create(clazz)
    }

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(Constant.DOMAIN)
            .addConverterFactory(GsonConverterFactory.create())
            .client(initOkHttpClient())
            .build()
    }

    private fun initOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(initCommonInterceptor())
            .hostnameVerifier { _, _ ->
                true
            }
            .build()
    }

    private fun initCommonInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request = chain.request()
                .newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("charset", "UTF-8")
                .build()
            chain.proceed(request)
        }
    }

}