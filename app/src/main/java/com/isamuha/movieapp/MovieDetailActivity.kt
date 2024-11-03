package com.isamuha.movieapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.isamuha.movieapp.databinding.ActivityMovieDetailBinding

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_24)  // Ganti dengan ikon Anda
        toolbar.setNavigationOnClickListener {
            // Aksi saat ikon navigasi diklik
            finish()
        }
        supportActionBar?.setDisplayShowTitleEnabled(false) // Nonaktifkan judul default


        // Menerima data movie dari Intent dan mengisi tampilan
        val poster = intent.getIntExtra("MOVIE_POSTER", 0)
        val title = intent.getStringExtra("MOVIE_TITLE") ?: "Unknown Title"
        val genre = intent.getStringExtra("MOVIE_GENRE") ?: "Unknown Genre"
        val rating = intent.getStringExtra("MOVIE_RATING") ?: "Unknown Rating"
        val duration = intent.getStringExtra("MOVIE_DURATION") ?: "Unknown Duration"
        val synopsis = intent.getStringExtra("MOVIE_SYNOPSIS") ?: "Synopsis not available"

        // Menampilkan data pada tampilan
        binding.imageMoviePoster.setImageResource(poster)
        binding.textMovieTitle.text = title
        binding.textViewMovieGenre.text = genre
        binding.textViewMovieDuration.text = duration
        binding.textViewMovieRating.text = rating
        binding.textViewMovieSynopsis.text = synopsis

        // Mengatur tombol kembali di toolbar
        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        // Mengatur tombol "BOOK FILM NOW"
        binding.buttonBookFilm.setOnClickListener {
            // Aksi untuk tombol BOOK FILM NOW, misalnya membuka halaman pemesanan
        }
    }
}
