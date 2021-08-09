package br.com.cotemig.daniel.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.daniel.R
import br.com.cotemig.daniel.models.Music
import coil.load
import coil.transform.RoundedCornersTransformation

class MusicAdapter(var context: Context, var music: List<Music>, var listener: ItemClick) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_music, parent, false)
        return MusicHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MusicHolder).bind(music[position], listener)
    }

    override fun getItemCount(): Int {
        return music.size
    }

    class MusicHolder(var view: View) : RecyclerView.ViewHolder(view) {
        fun bind(music: Music, listener: ItemClick) {

            var itemMusic = view.findViewById<RelativeLayout>(R.id.itemMusic)
            itemMusic.setOnClickListener {
                listener.click(music)
            }

            var artist = view.findViewById<TextView>(R.id.artist)
            artist.text = music.artist
            var title = view.findViewById<TextView>(R.id.title_music)
            title.text = music.title
            var cover = view.findViewById<ImageView>(R.id.cover)
            cover.load(music.thumb) {
                transformations(RoundedCornersTransformation((20).toFloat()))
            }
        }
    }

    interface ItemClick {
        fun click(music: Music)
    }
}