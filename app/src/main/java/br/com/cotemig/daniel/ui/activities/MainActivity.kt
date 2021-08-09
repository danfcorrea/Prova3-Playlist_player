package br.com.cotemig.daniel.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import br.com.cotemig.daniel.R
import br.com.cotemig.daniel.ui.fragments.LibraryFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragment(LibraryFragment.newInstance())
    }

    fun setFragment(f: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.conteudo, f)
        ft.commit()
    }
}