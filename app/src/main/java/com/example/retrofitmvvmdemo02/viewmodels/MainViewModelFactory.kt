package com.example.retrofitmvvmdemo02.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitmvvmdemo02.repository.NewsApiRepository

//It simply makes the ViewModel object with the given set of Parameters since we can't directly pass the parameters to the ViewModel
class MainViewModelFactory(private val repository : NewsApiRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}