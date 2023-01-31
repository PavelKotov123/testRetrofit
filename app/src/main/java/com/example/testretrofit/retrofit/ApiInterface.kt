package com.example.testretrofit.retrofit

import com.example.testretrofit.MainModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("/users/wt-t/repos")
    fun getRepos(): Call<MainModel>
}