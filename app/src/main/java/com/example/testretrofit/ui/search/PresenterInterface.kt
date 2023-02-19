package com.example.testretrofit.ui.search

import moxy.MvpView
import moxy.viewstate.strategy.alias.OneExecution

interface PresenterInterface : MvpView{
    fun showLoading() {

    }
    fun hideLoading() {

    }
    fun showError() {

    }
    fun onSignin() {

    }
}