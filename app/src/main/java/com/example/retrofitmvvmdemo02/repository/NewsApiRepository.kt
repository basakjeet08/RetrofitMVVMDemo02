package com.example.retrofitmvvmdemo02.repository

import com.example.retrofitmvvmdemo02.api.RetrofitInstance
import com.example.retrofitmvvmdemo02.model.NewsData
import retrofit2.Call

class NewsApiRepository {
    fun getNews(country: String, category: String): Call<NewsData> {
        return RetrofitInstance.apiCaller.getNews(country, category)
    }
}