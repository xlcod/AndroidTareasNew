package com.pernas.miapp.ui.MovieSearch


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pernas.miapp.R
import com.pernas.miapp.model.MovieDataClass


class MoviesAdapter(private val listener: (MovieDataClass) -> Unit) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    private var Movies = listOf<MovieDataClass>()

    fun addMovies(newMovies: List<MovieDataClass>) {
        this.Movies = newMovies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun getItemCount(): Int = Movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(Movies[position], listener)
    }

    class ViewHolder private constructor(view: View) : RecyclerView.ViewHolder(view) {
        private val movieTxt = view.findViewById<TextView>(R.id.MovieTextView)

            fun bind(myMovies: MovieDataClass, listener: (MovieDataClass) -> Unit) {
            movieTxt.text = myMovies.title
            this.itemView.setOnClickListener { listener.invoke(myMovies) }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
                return ViewHolder(view)
            }
        }
    }
}