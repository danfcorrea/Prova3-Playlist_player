package br.com.cotemig.daniel.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.daniel.R
import br.com.cotemig.daniel.models.Music
import br.com.cotemig.daniel.models.Playlist
import br.com.cotemig.daniel.services.RetrofitInitializer
import br.com.cotemig.daniel.ui.activities.PlayerActivity
import br.com.cotemig.daniel.ui.adapters.MusicAdapter
import br.com.cotemig.daniel.ui.adapters.PlaylistAdapter
import retrofit2.Call
import retrofit2.Response

class LibraryFragment : Fragment(), MusicAdapter.ItemClick {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_library, container, false)
        getPlaylist(view)
        return view
    }

    fun getPlaylist(view: View) {

        var s = RetrofitInitializer().servicePlaylist()
        var call = s.getPlaylist()

        call.enqueue(object : retrofit2.Callback<List<Playlist>> {
            override fun onResponse(
                call: Call<List<Playlist>>,
                response: Response<List<Playlist>>
            ) {
                if (response.code() == 200) {
                    response.body()?.let {
                        showPlaylist(view, it)
                    }
                }
            }

            override fun onFailure(call: Call<List<Playlist>>, t: Throwable) {
                Toast.makeText(context, "Ops", Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun showPlaylist(view: View, list: List<Playlist>) {
        var playlists = view.findViewById<RecyclerView>(R.id.playlists)
        playlists.adapter = PlaylistAdapter(requireContext(), list, this)
        playlists.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    companion object {

        fun newInstance(): LibraryFragment {
            return LibraryFragment()
        }
    }

    override fun click(music: Music) {
        var intent = Intent(context, PlayerActivity::class.java)
        intent.putExtra("music", music)
        startActivity(intent)
    }

}