package com.example.firstapiapplication.data.network

import com.example.firstapiapplication.data.network.client.BaseballClient
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private val BASE_URL ="https://tank01-mlb-live-in-game-real-time-statistics.p.rapidapi.com/"
    private val API_KEY = "9f80cb8b70mshf891e1e48acd400p17c5ddjsn6f88722770f9"
    private val HOST_URL_BASEBALL = "tank01-mlb-live-in-game-real-time-statistics.p.rapidapi.com"

    private val retrofit: Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient(HOST_URL_BASEBALL))
            .addConverterFactory(GsonConverterFactory.create()).build()


    private fun okHttpClient(host:String):OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(Interceptor {
                val request = it.request().newBuilder()
                    .addHeader("X-RapidAPI-Key", API_KEY)
                    .addHeader("X-RapidAPI-Host",host)
                    .build()
                it.proceed(request)
            }).build()
    }


    fun getClient():BaseballClient{
        return retrofit.create(BaseballClient::class.java)
    }
}