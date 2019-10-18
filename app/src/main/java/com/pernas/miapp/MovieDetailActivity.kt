package com.pernas.miapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.pernas.miapp.model.Movie
import com.pernas.miapp.model.MovieDataApi
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_detail.*



class MovieDetailActivity : AppCompatActivity() {


    val myApiMovies = listOf<MovieDataApi>(MovieDataApi(3, "Red dead ", 2, "1978", "Funny", 6.0))
    val myApiMovies1 = listOf<MovieDataApi>(MovieDataApi(3, "Red dead ", 2, "1978", "Funny", 6.0))
    val myApiMovies2 = listOf<MovieDataApi>(MovieDataApi(3, "Red dead ", 2, "1978", "Funny", 6.0))


    val movie = Movie(
        id = 1,
        title = "Revel in the chaos",
        year = "2016",
        genre = "Action",
        description = "Lorem Ipsum\n" +
                "\"Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...\"\n" +
                "\"There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain...\"\n" +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        rating = 7.5
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        with(movie) {
            movieTitle.text = title
            idYear.text = year
            idGenre.text = genre
            idDescription.text = description
            idRating.text = rating.toString()
        }
        Picasso.get().load("https://i.ytimg.com/vi/4Bvdp94K1uU/maxresdefault.jpg").into(imageView);

    }


    override fun onStart() {
        super.onStart()
        Log.e("MovieDetailActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("MovieDetailActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("MovieDetailActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("MovieDetailActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("MovieDetailActivity", "onDestroy")
    }
}
