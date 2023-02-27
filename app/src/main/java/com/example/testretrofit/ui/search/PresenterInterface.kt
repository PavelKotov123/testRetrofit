package com.example.testretrofit.ui.search

import android.os.Message
import android.widget.Toast
import com.example.testretrofit.repos.Repos
import moxy.InjectViewState
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.OneExecution

interface PresenterInterface : MvpView {
        @AddToEndSingle
        fun showError()

        @AddToEndSingle
        fun setupRecyclerView()
    }