package com.kim344.kotlinutils.retrofit2

import android.util.Log
import com.kim344.kotlinutils.retrofit2.Constant.Companion.URL_HOST
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInit {
    private var instance: RetrofitInit? = null

    private var retrofit = Retrofit.Builder()
        .baseUrl("$URL_HOST/")
        .client(client()).addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create()).build()

    var service: Service? = retrofit.create(Service::class.java)

    private fun client(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(loggingInterceptor()).build()
    }

    private fun loggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message ->
            Log.e(
                "Retrofit :",
                message + ""
            )
        })
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    fun getInstance(): RetrofitInit {
        if (instance != null) {
        } else
            instance = RetrofitInit()
        return instance as RetrofitInit
    }

}