package com.example.retrofitmvvmdemo02.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitmvvmdemo02.R
import com.example.retrofitmvvmdemo02.databinding.ActivityMainBinding
import com.example.retrofitmvvmdemo02.model.NewsData
import com.example.retrofitmvvmdemo02.repository.NewsApiRepository
import com.example.retrofitmvvmdemo02.utils.Constants
import com.example.retrofitmvvmdemo02.viewmodels.MainViewModel
import com.example.retrofitmvvmdemo02.viewmodels.MainViewModelFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = NewsApiRepository()

        viewModel = ViewModelProvider(this , MainViewModelFactory(repository))[MainViewModel::class.java]
        viewModel.getNews("us" , "business")
        viewModel.myCall.observe(this){call ->
            call.enqueue(object : Callback<NewsData>{
                override fun onResponse(call: Call<NewsData>, response: Response<NewsData>) {
                    d(Constants.TAG , response.body()!!.toString())
                }
                override fun onFailure(call: Call<NewsData>, t: Throwable) {
                    d(Constants.TAG , t.message.toString())
                }
            })
        }
    }
}