package com.example.testretrofit.ui.search

import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.testretrofit.data.remote.ApiServise
import com.example.testretrofit.databinding.ActivityMainBinding
import com.example.testretrofit.repos.Repos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import moxy.InjectViewState
import moxy.MvpPresenter
import moxy.MvpView

@InjectViewState
class SearchPresenter : MvpPresenter<PresenterInterface>(){
    lateinit var binding: ActivityMainBinding
    lateinit var mainAdapter: MainAdapter
    lateinit var userName: String
 fun searchRepos(){
        val userName: String = binding.tUserName.text.toString()
        Log.d("MYlog", userName)
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val response = ApiServise.endpoint.getRepos(userName)
                mainAdapter.setData(response)
            } catch (ex: Exception) {
                Log.d("MyLog","Work")
            }
        }
}
}