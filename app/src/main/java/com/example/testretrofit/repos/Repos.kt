package com.example.testretrofit.repos

import com.squareup.moshi.Json


data class Repos (
    @Json( name = "name")
    val name: String)