package com.example.firstapiapplication.data.network.client

import com.example.firstapiapplication.data.network.model.baseball.baseballDTO
import com.example.firstapiapplication.data.network.model.baseball.teamRoster.TeamRosterDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BaseballClient {
    @GET("getMLBTeams")
    suspend fun getTeams(): Response<baseballDTO>

    @GET("getMLBTeamRoster")
    suspend fun getTeamRoster(@Query("teamID") id:String):Response<TeamRosterDTO>
}