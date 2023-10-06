package com.example.firstapiapplication.ui.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapiapplication.data.network.model.baseball.teamRoster.Roster
import com.example.firstapiapplication.databinding.ItemDetailBinding

class DetailAdapter(var detailList: List<Roster>):RecyclerView.Adapter<DetailViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        return DetailViewHolder(ItemDetailBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int = detailList.size

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val item = detailList[position]
        holder.bind(item)
    }

    fun updateList(newList: List<Roster>){
        detailList = newList
        notifyDataSetChanged()
    }
}