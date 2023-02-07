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
//    private val TAG: String = "MainActivity"
    lateinit var mainAdapter: MainAdapter
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bSearch.setOnClickListener {

            var userName = binding.tUserName.text.toString()
            Log.d("MYlog", "$userName")

            setupRecyclerView()
            getDataFromApi(userName)
        }

    }
    private fun setupRecyclerView(){
        mainAdapter = MainAdapter(arrayListOf())
        recyclerView.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = mainAdapter
        }
    }

     private fun getDataFromApi(nameUser: String){

        ApiServise.endpoint.getRepos(nameUser)
            .enqueue(object : Callback<List<MainModel>>{
                override fun onResponse(
                    call: Call<List<MainModel>>,
                    response: Response<List<MainModel>>
                ) {
                    if (response.isSuccessful){
                        val result = response.body()
                        mainAdapter.setData( result!!)
                        Log.d("MyLog", result.toString())
                    }
                }

                override fun onFailure(call: Call<List<MainModel>>, t: Throwable) {
                    Log.d( "MyLog", "Error" )
                }

            })
    }
}
