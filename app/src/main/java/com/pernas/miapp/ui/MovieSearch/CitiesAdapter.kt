package com.pernas.miapp.ui.MovieSearch


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pernas.miapp.R
import com.pernas.miapp.model.MovieDataClass


class CitiesAdapter(private val listener: (MovieDataClass) -> Unit) :
    RecyclerView.Adapter<CitiesAdapter.ViewHolder>() {

    private var Movies = listOf<MovieDataClass>()

    fun addCities(newCities: List<MovieDataClass>) {
        this.Movies = newCities
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
        private val cityTxt = view.findViewById<TextView>(R.id.MovieTextView)

        fun bind(city: MovieDataClass, listener: (MovieDataClass) -> Unit) {
            cityTxt.text = city.title
            this.itemView.setOnClickListener { listener.invoke(city) }
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