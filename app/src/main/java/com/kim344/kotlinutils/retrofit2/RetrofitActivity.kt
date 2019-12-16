package com.kim344.kotlinutils.retrofit2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kim344.kotlinutils.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitActivity : AppCompatActivity() {

    private var retrofit: RetrofitInit? = null
    private var service: Service? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        setRetrofit()

        /* Init
        service?.getAnswers()?.enqueue(object : Callback<Model> {
            override fun onResponse(call: Call<Model>, response: Response<Model>) {
                Log.e("Retrofit", response.body()?.quota_max.toString())
                Log.e("Retrofit", response.body()?.quota_remaining.toString())
                Log.e("Retrofit", response.body()?.has_more.toString())
            }

            override fun onFailure(call: Call<Model>, t: Throwable) {

            }
        })
         */

        service?.getAnswers()?.enqueue(object : Callback<Model.VO>{
            override fun onFailure(call: Call<Model.VO>, t: Throwable) {
                Log.e("Retrofit onFailure", t.message)
            }

            override fun onResponse(call: Call<Model.VO>, response: Response<Model.VO>) {
                Log.e("Retrofit", response.body()?.quota_max.toString())
                Log.e("Retrofit", response.body()?.quota_remaining.toString())
                Log.e("Retrofit", response.body()?.has_more.toString())
            }

        })
    }

    private fun setRetrofit() {
        retrofit = RetrofitInit().getInstance()
        service = retrofit?.service
    }
}