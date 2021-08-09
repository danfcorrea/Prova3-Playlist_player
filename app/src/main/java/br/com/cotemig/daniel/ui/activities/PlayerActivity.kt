package br.com.cotemig.daniel.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import br.com.cotemig.daniel.R
import br.com.cotemig.daniel.models.Music
import coil.load
import coil.transform.RoundedCornersTransformation

class PlayerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        var music = intent.getSerializableExtra("music") as Music

        var dragDown = findViewById<ImageButton>(R.id.dragDown)
        dragDown.setOnClickListener {
            finish()
        }
        var cover = findViewById<ImageView>(R.id.cover)
        cover.load(music.thumb) {
            transformations(RoundedCornersTransformation((10).toFloat()))
        }
        var name = findViewById<TextView>(R.id.musicName)
        name.text = music.title
        name.setSelected(true)
        var artist = findViewById<TextView>(R.id.artistName)
        artist.text = music.artist

    }
}