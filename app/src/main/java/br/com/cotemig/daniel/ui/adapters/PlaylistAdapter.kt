package br.com.cotemig.daniel.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.daniel.R
import br.com.cotemig.daniel.models.Playlist

class PlaylistAdapter(var context: Context, var playlists: List<Playlist>, var listener: MusicAdapter.ItemClick) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_playlist, parent, false)
        return PlaylistHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PlaylistHolder).bind(context, playlists[position], listener)
    }

    override fun getItemCount(): Int {
        return playlists.size
    }

    class PlaylistHolder(var view: View) : RecyclerView.ViewHolder(view) {
        fun bind(context: Context, list: Playlist, listener: MusicAdapter.ItemClick) {
            var nome = view.findViewById<TextView>(R.id.title)
            nome.text = list.name

            var adapter = MusicAdapter(context, list.playlist, listener)
            var music = view.findViewById<RecyclerView>(R.id.music)
            music.adapter = adapter
            music.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            music.onFlingListener = null

            var quantMusic = view.findViewById<TextView>(R.id.quantMusicas)
            quantMusic.text = adapter.itemCount.toString().plus(" ")
        }
    }
}