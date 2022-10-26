package com.example.retrofitmvvmdemo02.api

import com.example.retrofitmvvmdemo02.model.NewsData
import com.example.retrofitmvvmdemo02.utils.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET(Constants.END_POINT)
    fun getNews(
        @Query("country")country:String = "us",
        @Query("category")category:String = "business",
        @Query("apiKey")apiKey : String = Constants.API_KEY
    ) : Call<NewsData>
}