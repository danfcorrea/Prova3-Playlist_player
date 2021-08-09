package br.com.cotemig.daniel.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val retrofit = Retrofit.Builder().baseUrl("https://api.radiola.app/v1/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    fun servicePlaylist(): ServicePlaylist {
        return retrofit.create(ServicePlaylist::class.java)
    }
}