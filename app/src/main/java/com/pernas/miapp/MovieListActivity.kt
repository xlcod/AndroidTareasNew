package com.pernas.miapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pernas.miapp.model.MovieDataApi
import com.pernas.miapp.ui.MoviesAdapter


class MovieListActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)


        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView

        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)


        val movies = ArrayList<MovieDataApi>()

        movies.add(MovieDataApi(1, "Jumanyi", "6", "23/3/49", "8.5", 6.0))
        movies.add(MovieDataApi(2, "Scary movie", "3", "24/3/66", "8.5", 6.5))
        movies.add(MovieDataApi(3, "Scooby Doo", "2", "24/3/55", "5.5", 7.0))
        movies.add(MovieDataApi(4, "Indiana jones", "1", "23/7/21", "8.5", 7.3))
        movies.add(MovieDataApi(1, "Pear harbor", "6", "23/3/11", "3.5", 3.0))
        movies.add(MovieDataApi(2, "Piratas del caribe", "3", "13/3/66", "5.5", 6.0))
        movies.add(MovieDataApi(3, "El Joker ", "2", "24/3/55", "1.5", 4.0))

        val adapter = MoviesAdapter(movies)

        recyclerView.adapter = adapter
    }


}