package com.example.firstapiapplication.ui.detail.adapter

import android.icu.util.Calendar
import android.icu.util.LocaleData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firstapiapplication.data.network.model.baseball.teamRoster.Roster
import com.example.firstapiapplication.databinding.ItemDetailBinding
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.util.Date

class   DetailViewHolder(private val binding:ItemDetailBinding):RecyclerView.ViewHolder(binding.root) {
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
        val fechaActual = Date()
        val format = SimpleDateFormat("dd/MM/yyyy")
        val fechaNacimiento = format.parse(item.bDay)
        val diferentMilisegundo = fechaActual.time - fechaNacimiento.time
        val age = (diferentMilisegundo / (1000*60*60*24*365.25)).toInt()

        binding.tvCollege.text = item.college
        binding.tvbDay.text = "Age: $age"
        binding.tvFistName.text = firstName
        binding.tvSecondName.text = secondName
        binding.tvJerseyNum.text = "#${item.jerseyNum}"
    }

}
