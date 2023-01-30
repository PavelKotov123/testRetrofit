package com.example.testretrofit.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testretrofit.Model.StarModel
import com.example.testretrofit.R
import kotlinx.android.synthetic.main.item_star_repositories.view.*

class StarsAdapter: RecyclerView.Adapter<StarsAdapter.StarViewHolder>() {

    private var starList = emptyList<StarModel>()

    class StarViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_star_repositories, parent, false)
        return StarViewHolder(view)
    }

    override fun getItemCount(): Int {
        return starList.size
    }

    override fun onBindViewHolder(holder: StarViewHolder, position: Int) {
        holder.itemView.tv_repositories.text = starList[position].repositories
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setlist(list: List<StarModel>){
        starList = list
        notifyDataSetChanged()
    }
}