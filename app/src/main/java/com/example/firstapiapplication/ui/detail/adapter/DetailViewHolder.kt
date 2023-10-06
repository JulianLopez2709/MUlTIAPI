package com.example.firstapiapplication.ui.detail.adapter

import android.icu.util.Calendar
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firstapiapplication.data.network.model.baseball.teamRoster.Roster
import com.example.firstapiapplication.databinding.ItemDetailBinding

class DetailViewHolder(private val binding:ItemDetailBinding):RecyclerView.ViewHolder(binding.root) {
    private lateinit var firstName:String
    private lateinit var secondName:String
    private lateinit var ege:String

    fun bind(item: Roster) {
        Glide
            .with(binding.root)
            .load(item.espnHeadshot)
            .into(binding.ivFoto)

        firstName = item.longName.split(" ")[0]
        secondName = item.longName.split(" ")[1]

        //Calcular Age
        val calendar = Calendar.getInstance()
        ege = item.bDay

        binding.tvCollege.text = item.college
        binding.tvbDay.text = item.bDay
        binding.tvFistName.text = firstName
        binding.tvSecondName.text = secondName
        binding.tvJerseyNum.text = "#${item.jerseyNum}"
    }

}
