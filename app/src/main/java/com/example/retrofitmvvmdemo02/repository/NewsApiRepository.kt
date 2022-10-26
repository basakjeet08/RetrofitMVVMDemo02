package com.example.retrofitmvvmdemo02.repository

import com.example.retrofitmvvmdemo02.api.RetrofitInstance
import com.example.retrofitmvvmdemo02.model.NewsData
import retrofit2.Call

class NewsApiRepository {

    //It uses the NewsApi interface and calls the @GET request through the RetrofitInstance class
    fun getNews(country: String, category: String): Call<NewsData> {
        return RetrofitInstance.apiCaller.getNews(country, category)
    }
}