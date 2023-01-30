package com.example.testretrofit

import retrofit2.Call
import retrofit2.http.GET

const val USER_NAME = "wt-t"
interface ApiInterfase {

    @GET("users/wt-t/starred")
    fun getData(): Call<List<MyDataItem>>
}