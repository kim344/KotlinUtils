package com.kim344.kotlinutils.retrofit2

import retrofit2.Call
import retrofit2.http.GET

interface Service {
    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    fun getAnswers(): Call<Model>
}