package com.example.testretrofit.ui.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testretrofit.repos.Repos
import com.example.testretrofit.databinding.ActivityMainBinding
import com.example.testretrofit.data.remote.ApiServise
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import moxy.MvpAppCompatActivity
import moxy.MvpView
import moxy.ktx.moxyPresenter
import moxy.presenter.InjectPresenter


class MainActivity : MvpAppCompatActivity(), PresenterInterface {
    lateinit var mainAdapter: MainAdapter
    lateinit var binding: ActivityMainBinding
    @InjectPresenter
    lateinit var repoPresenter: SearchPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()

        binding.bSearch.setOnClickListener {
            repoPresenter.searchRepos()
        }
    }
    private fun setupRecyclerView(){
        mainAdapter = MainAdapter(arrayListOf())
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = mainAdapter
        }
    }





    override fun showError() {
        Toast.makeText(applicationContext, "Error request", Toast.LENGTH_SHORT).show()
        binding.recyclerView.visibility = View.INVISIBLE
    }
}

