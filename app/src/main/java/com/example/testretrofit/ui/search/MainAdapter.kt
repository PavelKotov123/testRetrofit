package com.example.testretrofit.ui.search

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testretrofit.R
import com.example.testretrofit.databinding.ActivityMainBinding
import com.example.testretrofit.repos.Repos
import kotlinx.android.synthetic.main.item_repositories.view.*

class MainAdapter(val results : ArrayList<Repos>)
    : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    lateinit var binding: ActivityMainBinding
    class ViewHolder (val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.item_repositories, parent, false)
    )

    override fun getItemCount() = results.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = results[position]
        holder.view.tv_repositories.text = result.name
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(name: List<Repos>){
        results.clear()
        results.addAll( name )
        notifyDataSetChanged()
    }
}