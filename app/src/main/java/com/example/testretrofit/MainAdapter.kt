package com.example.testretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_repositories.view.*

class MainAdapter(val results : ArrayList<MainModel>)
    : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    class ViewHolder (val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.item_repositories, parent, false)
    )

    override fun getItemCount() = results.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = results[position]
        holder.view.tv_repositories.text = result.name
    }

    fun setData(name: List<MainModel>){
        results.clear()
        results.addAll( name )
        notifyDataSetChanged()
    }

}