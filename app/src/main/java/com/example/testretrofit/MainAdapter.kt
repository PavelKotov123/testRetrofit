package com.example.testretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_repositories.view.*

class MainAdapter(val results : ArrayList<MainModel.Result>)
    : RecyclerView.Adapter<MainAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_repositories, parent, false) //val itemView = перед LayoutInflater и круглые скобки
//        return ViewHolder(itemView)
    }                                                                                                //Какая то проблема

    override fun getItemCount() = results.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = results[position]
        holder.view.tv_repositories.text = result.name
    }

    class ViewHolder (val view: View) : RecyclerView.ViewHolder(view)

    fun setData(name: List<MainModel.Result>){
        results.clear()
        results.addAll( name )
        notifyDataSetChanged()
    }

}