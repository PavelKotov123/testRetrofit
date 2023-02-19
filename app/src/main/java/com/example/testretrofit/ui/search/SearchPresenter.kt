package com.example.testretrofit.ui.search

import com.example.testretrofit.repos.Repos
import moxy.InjectViewState
import moxy.MvpPresenter
import moxy.MvpView

@InjectViewState
class SearchPresenter : MvpPresenter<MvpView>() {



    private var nameUser : String = ""
    fun onButtonSearchClicked(repos: String) {
        nameUser = repos

    }

}