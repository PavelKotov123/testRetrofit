package com.example.testretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.testretrofit.Adapter.StarsAdapter
import com.example.testretrofit.Model.StarModel
import com.example.testretrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



const val BASE_URL = "https://api.github.com/"
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: StarsAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getMyData()    //Запуск функции для запроса репозиториев,и передача в логи

        initial()    //Запуск функции для передачи списка в activity_main
    }

    //Функция передачи данных в activity_main
    fun initial() {
        recyclerView = binding.rvStars
        adapter = StarsAdapter()
        recyclerView.adapter = adapter
        adapter.setlist(myStars())

    }
    //Функция создания списка для теста передачи данных в activity_main
    fun myStars(): ArrayList<StarModel> {
        val starList = ArrayList<StarModel>()
        val star = StarModel("qwerty123")
        starList.add(star)

        return starList
    }



//Функция для получения данных из запроса по full_name избранных репозиториев
    fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterfase::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<MyDataItem>?> {
            override fun onResponse(call: Call<List<MyDataItem>?>, response: Response<List<MyDataItem>?>) {
                val responseBody = response.body()!!
                val myStringBuilder = StringBuilder()

                for (myData in responseBody){
                    myStringBuilder.append(myData.full_name)
                    myStringBuilder.append("\n")
                }

                Log.d("MyLog","$myStringBuilder")

            }
            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {

                Log.d("MyLog","onFailure: "+t.message)

            }
        })
    }

}
