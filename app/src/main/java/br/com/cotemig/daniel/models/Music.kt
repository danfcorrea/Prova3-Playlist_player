package br.com.cotemig.daniel.models

import java.io.Serializable

data class Music(
    var artist: String = "",
    var thumb: String = "",
    var title: String = "",
    var duration: Int
) : Serializable