package com.isamuha.movieapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.isamuha.movieapp.databinding.ItemMovieBinding

class MovieAdapter(private val movieList: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        with(holder.binding) {
            imageMoviePoster.setImageResource(movie.poster)
            textMovieTitle.text = movie.title
            textMovieDuration.text = movie.duration
            movieRating.text = movie.rating

        }

        // Menambahkan klik listener untuk navigasi ke detail
        holder.binding.root.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra("MOVIE_POSTER", movie.poster)
            intent.putExtra("MOVIE_TITLE", movie.title)
            intent.putExtra("MOVIE_GENRE", movie.genre)
            intent.putExtra("MOVIE_RATING", movie.rating)
            intent.putExtra("MOVIE_DURATION", movie.duration)
            intent.putExtra("MOVIE_SYNOPSIS", movie.synopsis)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = movieList.size
}
