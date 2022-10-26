package com.example.retrofitmvvmdemo02.api

import com.example.retrofitmvvmdemo02.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val apiCaller : NewsApi by lazy {
        retrofit.create(NewsApi::class.java)
    }
}