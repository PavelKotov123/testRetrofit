package com.example.testretrofit.ui.search

import android.widget.Toast
import moxy.InjectViewState
import moxy.MvpView
import moxy.viewstate.strategy.alias.OneExecution


interface PresenterInterface : MvpView{
    fun showLoading() {


    }
    fun hideLoading() {

    }
    fun showError() {
//        Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
    }
    fun onSignin() {

    }
}