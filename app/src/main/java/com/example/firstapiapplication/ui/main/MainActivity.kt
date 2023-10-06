package com.example.firstapiapplication.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapiapplication.R
import com.example.firstapiapplication.databinding.ActivityMainBinding
import com.example.firstapiapplication.ui.main.adapter.TeamsAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: TeamsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAdapter()
        viewModel.listBaseball.observe(this){
            adapter.updateList(it)
        }
        viewModel.errorLiveData.observe(this){
            println(it)
        }

        viewModel.getRetrofit()
    }

    private fun initAdapter() {
        adapter = TeamsAdapter(emptyList())
        binding.rvTeams.layoutManager = LinearLayoutManager(this)
        binding.rvTeams.adapter = adapter
    }
}