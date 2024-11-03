package com.isamuha.movieapp

import android.widget.ImageView
import java.io.Serializable

data class Movie(
    val title: String,
    val duration: String,
    val rating: String,
    val genre: String,
    val poster: Int,
    val synopsis: String
)

