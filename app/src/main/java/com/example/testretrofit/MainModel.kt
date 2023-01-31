package com.example.testretrofit

data class MainModel ( val result: ArrayList<Result>) {
  data class Result ( val name: String)
}