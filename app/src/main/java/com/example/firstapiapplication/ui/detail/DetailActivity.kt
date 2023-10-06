package com.example.firstapiapplication.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapiapplication.R
import com.example.firstapiapplication.databinding.ActivityDetailBinding
import com.example.firstapiapplication.ui.detail.adapter.DetailAdapter
import com.example.firstapiapplication.ui.main.adapter.TeamsAdapter

class DetailActivity : AppCompatActivity() {
    private lateinit var adapter: DetailAdapter
    private lateinit var binding: ActivityDetailBinding
    private lateinit var id:String
    private val detailViewModel: DetalViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        id = intent.getStringExtra("teamID").toString()
        initViewModel()
        initAdapter()
        initLister()
    }

    private fun initLister() {
        binding.btnBack.setOnClickListener{
            onBackPressed()
        }
    }

    private fun initViewModel() {
        detailViewModel.listBaseball.observe(this){
            adapter.updateList(it)
        }
        detailViewModel.errorLiveData.observe(this){
            println(it)
        }

        detailViewModel.getDetailTeam(id)
    }

    private fun initAdapter() {
        adapter = DetailAdapter(emptyList())
        binding.rvDetail.adapter = adapter
        binding.rvDetail.layoutManager = LinearLayoutManager(this)
    }
}