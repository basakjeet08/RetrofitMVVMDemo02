package com.example.retrofitmvvmdemo02.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitmvvmdemo02.model.NewsData
import com.example.retrofitmvvmdemo02.repository.NewsApiRepository
import retrofit2.Call

class MainViewModel(private val repository: NewsApiRepository) : ViewModel() {
    var myCall : MutableLiveData<Call<NewsData>> = MutableLiveData()

    fun getNews(country : String , category : String){
        myCall.value = repository.getNews(country , category)
    }
}