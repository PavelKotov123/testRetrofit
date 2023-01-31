package com.example.testretrofit


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testretrofit.databinding.ActivityMainBinding
import com.example.testretrofit.retrofit.ApiServise
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val TAG: String = "MainActivity"
    lateinit var mainAdapter: MainAdapter
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onStart() {
        super.onStart()
        setupRecyclerView()
        getDataFromApi()
    }

    private fun setupRecyclerView(){
        mainAdapter = MainAdapter(arrayListOf())
        recyclerView.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = mainAdapter
        }
    }
    private fun getDataFromApi(){

        ApiServise.endpoint.getRepos()
            .enqueue(object : Callback<MainModel>{
                override fun onResponse(
                    call: Call<MainModel>,
                    response: Response<MainModel>
                ) {
                    if (response.isSuccessful){
                        val result = response.body()
                        showRepos( result!!)
                    }
                }

                override fun onFailure(call: Call<MainModel>, t: Throwable) {
                    printLog( t.toString() )
                }

            })
    }

    private fun printLog(message: String){
        Log.d(TAG, message)
    }

    private fun showRepos(repos: MainModel) {
        val results = repos.result
        mainAdapter.setData( results )
//        for(result in results){
//            printLog("Repo: ${result.name}")
//        }
    }

}
