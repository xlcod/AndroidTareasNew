package com.pernas.miapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pernas.miapp.model.Movie


class MovieAdapter(private val listener: (Movie) -> Unit): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private var movies = listOf<Movie>()

    fun addCities(newCities: List<Movie>) {
        this.movies = newCities
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position], listener)
    }

    class ViewHolder private constructor(view: View): RecyclerView.ViewHolder(view) {
        private val cityTxt = view.findViewById<TextView>(R.id.MovieTextView)

        fun bind(city: Movie, listener: (Movie) -> Unit) {
            cityTxt.text = city.title
            this.itemView.setOnClickListener { listener.invoke(city) }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
                return ViewHolder(view)
            }
        }
    }
}