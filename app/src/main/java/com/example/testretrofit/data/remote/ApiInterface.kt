package com.example.testretrofit.data.remote

import com.example.testretrofit.repos.Repos
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("users/{name}/repos")
    fun getRepos(@Path("name") postName: String): Call<List<Repos>>
}