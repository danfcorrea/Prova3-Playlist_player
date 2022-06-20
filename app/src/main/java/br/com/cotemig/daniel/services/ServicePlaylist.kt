package br.com.cotemig.daniel.services

import br.com.cotemig.daniel.models.Playlist
import retrofit2.Call
import retrofit2.http.GET

interface ServicePlaylist {
    @GET("Playlist")
    fun getPlaylist(): Call<List<Playlist>>
}