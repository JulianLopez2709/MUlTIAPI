package com.example.firstapiapplication.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.firstapiapplication.data.network.model.baseball.Body
import com.example.firstapiapplication.databinding.ItemTeamsBinding

class TeamsAdapter(private var listTeams:List<Body>):RecyclerView.Adapter<TeamsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamsViewHolder {
       return TeamsViewHolder(ItemTeamsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int = listTeams.size

    override fun onBindViewHolder(holder: TeamsViewHolder, position: Int) {
        val item = listTeams[position]
       holder.bind(item)
    }

    fun updateList(newList:List<Body>){
        listTeams = newList
        notifyDataSetChanged()
    }
}