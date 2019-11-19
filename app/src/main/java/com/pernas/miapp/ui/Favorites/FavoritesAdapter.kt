package com.pernas.miapp.ui.Profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pernas.miapp.R
import com.pernas.miapp.data.Local.MovieData
import com.pernas.miapp.model.MovieDataClass
import com.pernas.miapp.ui.MovieSearch.MoviesAdapter

class FavoritesAdapter() : RecyclerView.Adapter<FavoritesAdapter.ViewHolder>() {


    private var favorites = listOf<MovieData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesAdapter.ViewHolder {
       return ViewHolder.from(parent)
    }

    fun addMyFavorites(myFavorites: List<MovieData>) {
        this.favorites = myFavorites
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
       return   favorites.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(favorites[position])
    }


    class ViewHolder private constructor(view: View) : RecyclerView.ViewHolder(view) {
        private val favoriteStringTxt = view.findViewById<TextView>(R.id.MovieTextView)

        fun bind(myfavorites: MovieData) {
            favoriteStringTxt.text = myfavorites.title
            //this.itemView.setOnClickListener { listener.invoke(MovieData) }
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