package com.pernas.miapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup


import android.view.View

import androidx.recyclerview.widget.RecyclerView

import com.pernas.miapp.R
import com.pernas.miapp.model.MovieDataApi

import kotlinx.android.synthetic.main.string_item.view.*

class MoviesAdapter(val movieList: ArrayList<MovieDataApi>) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesAdapter.ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.string_item, parent, false)

        return ViewHolder(v)
    }


    override fun onBindViewHolder(holder: MoviesAdapter.ViewHolder, position: Int) {
        holder.bindItems(movieList[position])
    }


    override fun getItemCount(): Int {
        return movieList.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun bindItems(movie: MovieDataApi) {
            val movietittle = itemView.titleView
            val movieoriginal = itemView.ogtitleView
            val movieyear = itemView.dateContent
            val movieAverage = itemView.ratingView
            movietittle.text = movie.title
            movieoriginal.text = movie.genre_ids
            movieAverage.text = movie.vote_average.toString()
            movieyear.text = movie.release_date

        }
    }
}
