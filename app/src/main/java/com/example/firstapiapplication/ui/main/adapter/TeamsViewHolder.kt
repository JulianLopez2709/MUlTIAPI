package com.example.firstapiapplication.ui.main.adapter

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firstapiapplication.data.network.model.baseball.Body
import com.example.firstapiapplication.databinding.ItemTeamsBinding
import com.example.firstapiapplication.ui.detail.DetailActivity

class TeamsViewHolder(private val binding:ItemTeamsBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Body) {
        //barra de wins

        binding.tvNameTeam.text = item.teamName
        binding.tvWins.text = item.wins
        Glide
            .with(binding.root)
            .load(item.espnLogo1)
            .into(binding.ivLogo)

        binding.root.setOnClickListener {
            val intent = Intent(binding.root.context,DetailActivity::class.java)
            intent.putExtra("teamID",item.teamID)
            binding.root.context.startActivity(intent)
        }
    }

}
