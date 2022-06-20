package br.com.cotemig.daniel.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val retrofit = Retrofit.Builder().baseUrl("https://62a7af2197b6156bff91f465.mockapi.io/api/v1/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    fun servicePlaylist(): ServicePlaylist {
        return retrofit.create(ServicePlaylist::class.java)
    }
}