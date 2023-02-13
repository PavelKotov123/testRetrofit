package com.example.testretrofit.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


object ApiServise {
    val BASE_URL: String = "https://api.github.com/"
    val endpoint: ApiInterface

    get(){
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        return retrofit.create(ApiInterface::class.java)
    }
}