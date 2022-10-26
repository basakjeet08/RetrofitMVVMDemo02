package com.example.retrofitmvvmdemo02.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitmvvmdemo02.adapters.NewsApiAdapter
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

    //binding object which contains the UI id bindings
    private lateinit var binding : ActivityMainBinding

    //viewModel variable which is used to access the viewModel properties
    private lateinit var viewModel : MainViewModel

    // adapter for binding the RecyclerView of the layout
    private val adapter by lazy { NewsApiAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //this functions sets the RecyclerView adapters and the layout Manager
        setupRecyclerView()

        //Repository variable created to be passed in the ViewModelFactory
        val repository = NewsApiRepository()

        //Creating the ViewModel object and storing it in viewModel variable
        viewModel = ViewModelProvider(this , MainViewModelFactory(repository))[MainViewModel::class.java]

        //Calling the getNews of the ViewModel which asks for the data from the Repository Class(Rest API)
        viewModel.getNews("us" , "business")

        //Setting the observer of the myCall variable at ViewModel and this part will be executed when the data changes
        viewModel.myCall.observe(this){
            myCallObserver(it)
        }
    }

    //This function sets up the RecyclerView adapter and layout
    private fun setupRecyclerView(){
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    //This function is Executed when the myCall value changes
    private fun myCallObserver(call : Call<NewsData>){
        call.enqueue(object : Callback<NewsData>{

            //If we get a positive response then this block is executed
            override fun onResponse(call: Call<NewsData>, response: Response<NewsData>) {
                /**
                 * Checking if the received response is valid or invalid and for valid response we are
                 * Updating the list at the adapter class which changes the data and sets it again
                 */
                if(!response.isSuccessful)
                    Toast.makeText(baseContext , "Not Working" , Toast.LENGTH_SHORT).show()
                else
                    adapter.updateList(response.body()!!.articles!!)
            }

            // This function is called when there is no response or a failure
            override fun onFailure(call: Call<NewsData>, t: Throwable) {
                d(Constants.TAG , t.message.toString())
            }
        })
    }
}