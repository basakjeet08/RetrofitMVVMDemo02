package com.example.retrofitmvvmdemo02.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitmvvmdemo02.model.NewsData
import com.example.retrofitmvvmdemo02.repository.NewsApiRepository
import retrofit2.Call

class MainViewModel(private val repository: NewsApiRepository) : ViewModel() {

    //This mutableLiveData contains the Call object received from the Repository class
    var myCall : MutableLiveData<Call<NewsData>> = MutableLiveData()

    //It requests the repository class for the data and sets the new data to the mutableLiveData which is being seen by the MainActivity
    fun getNews(country : String , category : String){
        myCall.value = repository.getNews(country , category)
    }
}